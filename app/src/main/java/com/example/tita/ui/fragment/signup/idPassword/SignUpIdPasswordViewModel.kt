package com.example.tita.ui.fragment.signup.idPassword

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tita.data.network.SignUpInterface
import com.example.tita.data.repository.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.NullPointerException
import javax.inject.Inject

@HiltViewModel
class SignUpIdPasswordViewModel @Inject constructor(
    private val repository: SignUpRepository
) : ViewModel() {

    private lateinit var _idTest: MutableLiveData<Boolean>
    val idTest: LiveData<Boolean> get() = _idTest

    private var _id=MutableLiveData<String>()
    val id: LiveData<String> get()=_id

    @SuppressLint("LongLogTag")
    suspend fun postUserName(username:String) = viewModelScope.launch(IO) {

        try {
            // 아이디를 요청
                // 아이디를 사용할수 잇는지 판단?
            repository.postUserName(username).let { response->
                if(response.isSuccessful) {
                    when (response.body()?.message) {
                        success -> {
                            _id.value = "사용가능한 id 입니다."
                            _idTest.postValue(true)
                        }
                        fail -> {
                            _idTest.postValue(false)
                        }


                        else -> {
                            Log.d(TAG, "postUserName: ")
                        }
                    }
                }else{
                    Log.d(TAG, "postUserName: ")
                }
            }
        }catch (e:NullPointerException){
            _id.value="서버 에러"
        }


    }

    init {
        _idTest.value=false

    }

    companion object{
        const val TAG="SignUpIdPasswordViewModel"
        const val success="성공입니다."
        const val fail="실패입니다."

    }


}
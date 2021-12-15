package com.example.tita.ui.fragment.login

import android.util.Log
import androidx.lifecycle.*
import com.example.tita.Resource
import com.example.tita.data.network.dto.LoginData
import com.example.tita.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private var _postLogin = MutableLiveData<Resource<LoginData>>()
    val postLogin: LiveData<Resource<LoginData>> get() = _postLogin

    private var _errorLogin = MutableLiveData<Boolean>(false)
    val errorLogin: LiveData<Boolean> get() = _errorLogin


    // 로그인을 할때 성공이면 패스 false 면 이유뜨게
    suspend fun checkLogin(id: String, pwd: String) = viewModelScope.launch(IO) {
        _postLogin.postValue(Resource.Loading())
        try {
            loginRepository.postLogin(id, pwd).let { response ->
                if (response.isSuccessful) {
                    response.body()?.let { _postLogin.postValue(Resource.Success(it)) }
                    Log.d(TAG, "checkLogin: ")
                    _errorLogin.value = true

                }
            }
        } catch (e: KotlinNullPointerException) {
            _postLogin.postValue(Resource.Error("서버 에러"))
        }
    }

    companion object {
        val TAG = "LoginViewModel"
    }
}



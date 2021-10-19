package com.example.tita.ui.findidpassword.fragment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetPasswordCodeUseCase
import com.example.domain.usecase.PostPasswordUseCase
import com.example.tita.base.BaseViewModel
import com.example.tita.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class FindIdPasswordViewModel @Inject constructor(
    private val getPasswordCodeUseCase : GetPasswordCodeUseCase,
    private val postPasswordUseCase: PostPasswordUseCase
) : BaseViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> get() = _email

    private val _isSuccess = MutableLiveData<Event<String>>()
    val isSuccess: LiveData<Event<String>> = _isSuccess

    private val _id = MutableLiveData<String>()
    val id : LiveData<String> get() = _id

    private val _isFailure = MutableLiveData<Event<String>>()
    val isFailure: LiveData<Event<String>> = _isFailure

    private val _code = MutableLiveData<String>()
    val code : LiveData<String> get() = _code


    suspend fun passwordChangeAuthoritySend(email : String, id : String){

        _email.value = email
        _id.value = id

        try {
            addDisposable(
                postPasswordUseCase.buildUseCaseObservable(PostPasswordUseCase.Params(_email.value!!,_id.value!!))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ inside ->
                        Log.d("TAG", "password change Logic: ${inside.msg}")

                        _isSuccess.value = Event(inside.msg)

                    } , {
                        _isFailure.value = Event("존재하지않는 회원이거나 아이디 및 이메일을 잘못 입력하셨습니다.")
                    })
            )
        }
        catch (e : Exception){
            Log.d("dsaf",e.toString())
            _isFailure.value = Event(e.toString())
        }
    }

    suspend fun getPasswordChangeCode(code : String){
        _code.value = code

        try {
            addDisposable(
                getPasswordCodeUseCase.buildUseCaseObservable(GetPasswordCodeUseCase.Params(_code.value!!))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.d("TAG", "password change Logic: ${it.msg}")

                        _isSuccess.value = Event(it.msg)

                    }, {
                        _isFailure.value = Event(it.message ?: "")
                    })
            )
        }
        catch (e : Exception){
            Log.d("dafs",e.toString())
            _isFailure.value = Event(e.toString())
        }
    }

}
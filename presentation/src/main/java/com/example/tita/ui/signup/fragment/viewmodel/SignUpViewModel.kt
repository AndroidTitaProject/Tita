package com.example.tita.ui.signup.fragment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.usecase.signup.IdCheckUseCase
import com.example.domain.usecase.signup.NickNameUseCase
import com.example.domain.usecase.signup.PostMailUseCase
import com.example.domain.usecase.signup.SignUpUseCase
import com.example.tita.base.BaseViewModel
import com.example.tita.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val postMailUseCase: PostMailUseCase,
    private val getIdCheckUseCase: IdCheckUseCase,
    private val nickNameUseCase: NickNameUseCase
) : BaseViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val TAG = "SignUp"


    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    private val _nickName = MutableLiveData<String>()
    val nickName: LiveData<String> get() = _nickName

    private val _school = MutableLiveData<String>()
    val school: LiveData<String> get() = _school

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _isSuccess = MutableLiveData<Event<String>>()
    val isSuccess: LiveData<Event<String>> = _isSuccess

    private val _isFailure = MutableLiveData<Event<String>>()
    val isFailure: LiveData<Event<String>> = _isFailure

    private val _userName = MutableLiveData<String>()
    val userName : LiveData<String> get()=_userName
    private val _mail = MutableLiveData<String>()
    val mail: LiveData<String> get() = _mail

    private val _id = MutableLiveData<String>()
    val id: LiveData<String> get() = this._id

    // 메일인증
    suspend fun getMail(mail: String) {

        _mail.value = mail
        try {
            postMailUseCase.buildUseCaseObservable(PostMailUseCase.Params(_mail.value.toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    Log.d(TAG, "getMail: ${_mail.value}")
                    _isSuccess.value = Event(data.msg)
                }, {
                    _isFailure.value = Event(it.message ?: "")
                }).apply {
                    compositeDisposable.add(this)
                }
        } catch (e: Exception) {
            _isFailure.value = Event(e.toString())
        }
    }

    // 아이디 중복확인
    suspend fun idCheck(id: String) {

        _id.value = id
        try {

            addDisposable(
                getIdCheckUseCase.buildUseCaseObservable(IdCheckUseCase.Params(_id.value!!))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.d("TAG", "idCheck: ${it.msg}")
                        Log.d(TAG, "idCheck: ${_id.value}")
                        _isSuccess.value = Event(it.msg)
                    }, {
                        Log.d(TAG, "idCheck: throw :${it.message}")
                        _isFailure.value = Event(it.message ?: "")
                    })
            )
        } catch (e: Exception) {
            Log.d(TAG, "idCheck: error ${e}")
            _isFailure.value = Event(e.toString())
        }


    }

    fun getUserName(userName:String){
        _userName.value=userName
    }
    fun getSchoolName(school:String){
        _school.value=school
    }


    // 비밀번호 받아오기
    fun getPassword(password:String){
        _password.value=password
    }


    fun getEmail(email: String){
        _email.value=email
    }

    suspend fun nickNameOverlap(name: String) {
        _nickName.value = name
        try {

            addDisposable(
                nickNameUseCase.buildUseCaseObservable(NickNameUseCase.Params(_nickName.value!!))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.d(TAG, "nickNameOverlap: ${_nickName.value}")
                        _isSuccess.value = Event(it.msg)
                    }, {
                        _isFailure.value = Event(it.message ?: "")
                    })
            )
        } catch (e: Exception) {
            _isFailure.value = Event(e.toString())
        }
    }

    suspend fun signUp(nickName: String) {
        _nickName.value = nickName
        try {
            addDisposable(
                signUpUseCase.buildUseCaseObservable(
                    SignUpUseCase.Params(
                        _id.value.toString(),
                        _password.value.toString(),
                        _nickName.value.toString(),
                        _school.value.toString(),
                        _email.value.toString()
                    )
                )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.d("TAG", "signUp: ${it.msg}")

                        _isSuccess.value = Event(it.msg)
                    }, {
                        _isFailure.value = Event(it.message ?: "")
                    })
            )
        } catch (e: Exception) {
            _isFailure.value = Event(e.toString())
        }


    }
}


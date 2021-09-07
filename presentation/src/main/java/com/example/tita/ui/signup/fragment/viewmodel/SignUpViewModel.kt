package com.example.tita.ui.signup.fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetMailUseCase
import com.example.domain.usecase.SignUpUseCase
import com.example.tita.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val getMailUseCase: GetMailUseCase
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> get() = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    private val _school = MutableLiveData<String>()
    val school: LiveData<String> get() = _school

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _isSuccess = MutableLiveData<Event<String>>()
    val isSuccess: LiveData<Event<String>> = _isSuccess

    private val _isFailure = MutableLiveData<Event<String>>()
    val isFailure: LiveData<Event<String>> = _isFailure

    private val _mail = MutableLiveData<String>()
    val mail: LiveData<String> get() = _mail

    suspend fun getMail(mail: String) {

        _mail.value =mail
            getMailUseCase.buildUseCaseObservable(GetMailUseCase.Params(_mail.value.toString()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _isSuccess.value = Event(it.msg)
                }, {
                    _isFailure.value = Event(it.message ?: "")
                }).apply {
                    compositeDisposable.add(this)
                }

    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


}
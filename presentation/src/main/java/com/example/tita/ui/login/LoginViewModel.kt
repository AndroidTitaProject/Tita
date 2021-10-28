package com.example.tita.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.LoginUseCase
import com.example.tita.base.BaseViewModel
import com.example.tita.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCase: LoginUseCase
) : BaseViewModel() {

    private val _id = MutableLiveData<String>()
    val id: LiveData<String> get() = _id
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password


    private val _isSuccess = MutableLiveData<Event<String?>>()
    val isSuccess: LiveData<Event<String?>> = _isSuccess

    private val _isFailure = MutableLiveData<Event<String?>>()
    val isFailure: LiveData<Event<String?>> = _isFailure



    suspend fun login(id: String, password: String) = viewModelScope.launch {

        _id.value = id
        _password.value = password
        try {
            addDisposable(
                useCase.buildUseCaseObservable(LoginUseCase.Params(_id.value!!, _password.value!!))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _isSuccess.value = Event(it.msg)

                    }, {

                        _isFailure.value = Event(it.message)
                    })

            )
        } catch (e: Exception) {

        }
    }

}
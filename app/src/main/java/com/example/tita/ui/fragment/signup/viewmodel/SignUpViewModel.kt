package com.example.tita.ui.fragment.signup.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.tita.Resource
import com.example.tita.data.network.dto.MailData
import com.example.tita.data.repository.LoginRepository
import com.example.tita.util.textAnimation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.NullPointerException
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    // 뮤터블은 값을 수정, 삭제, 추가 가능
    // private 을 get() 으로 초기화 한 이유
    // 객체지향의 캡슐화를 지키기 위해서다.
    private val _checkFindErrorIdText = MutableLiveData<Boolean>()
    val checkErrorIdText: MutableLiveData<Boolean> get() = _checkFindErrorIdText

    private val _checkPasswordErrorIdText = MutableLiveData<Boolean>()
    val checkPasswordErrorIdText: MutableLiveData<Boolean> get() = _checkPasswordErrorIdText
    private val _checkErrorCer = MutableLiveData<Boolean>()
    val checkErrorCer: MutableLiveData<Boolean> get() = _checkErrorCer
    private val _checkErrorEdit = MutableLiveData<Boolean>()
    val checkErrorEdit: MutableLiveData<Boolean> get() = _checkErrorEdit

    private val _checkPasswordErrorText = MutableLiveData<Boolean>()
    val checkPasswordErrorText: MutableLiveData<Boolean> get() = _checkPasswordErrorText

    private val _checkPasswordOneErrorText = MutableLiveData<Boolean>()
    val checkPasswordErrorOneText: MutableLiveData<Boolean> get() = _checkPasswordOneErrorText


    private val _checkErrorEmail = MutableLiveData<Boolean>()
    val checkErrorEmail: MutableLiveData<Boolean> get() = _checkErrorEmail

    private var _postMail = MutableLiveData<Resource<MailData>>()
    val postMail: LiveData<Resource<MailData>> get() = _postMail

    private val _mailText = MutableLiveData<String>()
    val mailText: LiveData<String> get() = _mailText

    private val _checkMail = MutableLiveData<Boolean>()
    val checkMail: LiveData<Boolean> get() = _checkMail


    fun mailSend(mail: String) = viewModelScope.launch {
        _postMail.postValue(Resource.Loading())
        try {
            loginRepository.postMail(mail).let { response ->
                if (response.isSuccessful) {
                    response.body()?.let { _postMail.postValue(Resource.Success(it)) }
                    _mailText.postValue("인증번호가 전송되었습니다.")
                    _checkMail.postValue(true)
                }
            }
        } catch (e: NullPointerException) {

        }
    }

    fun checkEmail() {
        _checkErrorEmail.value = true
    }


    fun checkId() {
        _checkFindErrorIdText.value = true
    }

    fun checkCertification() {
        _checkErrorEdit.value = true
    }


}

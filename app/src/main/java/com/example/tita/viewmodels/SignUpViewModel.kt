package com.example.tita.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SignUpViewModel(application: Application) : AndroidViewModel(application) {

    // 뮤터블은 값을 수정, 삭제, 추가 가능
    // private 을 get() 으로 초기화 한 이유
    // 객체지향의 캡슐화를 지키기 위해서다.
    private val _checkFindErrorIdText = MutableLiveData<Boolean>()
    val checkErrorIdText: MutableLiveData<Boolean> get() = _checkFindErrorIdText

    private val _checkPasswordErrorIdText = MutableLiveData<Boolean>()
    val checkPasswordErrorIdText: MutableLiveData<Boolean> get() = _checkPasswordErrorIdText

    private val _checkErrorEdit = MutableLiveData<Boolean>()
    val checkErrorEdit: MutableLiveData<Boolean> get() = _checkErrorEdit

    private val _checkPasswordErrorText = MutableLiveData<Boolean>()
    val checkPasswordErrorText: MutableLiveData<Boolean> get() = _checkPasswordErrorText

    private val _checkPasswordOneErrorText = MutableLiveData<Boolean>()
    val checkPasswordErrorOneText: MutableLiveData<Boolean> get() = _checkPasswordOneErrorText

    private val _checkErrorNickName = MutableLiveData<Boolean>()
    val checkErrorNickName: MutableLiveData<Boolean> get() = _checkErrorNickName

    private val _checkErrorEmail = MutableLiveData<Boolean>()
    val checkErrorEmail: MutableLiveData<Boolean> get() = _checkErrorEmail



    fun checkEmail() {
        checkErrorEmail.value = true
    }


    fun checkId() {
        checkErrorIdText.value = true
    }

    fun checkCertification() {
        checkErrorEdit.value = true
    }

    fun checkNickName() {
        checkErrorNickName.value = true
    }
}

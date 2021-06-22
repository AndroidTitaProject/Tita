package com.example.tita.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SignUpViewModel(application: Application) : AndroidViewModel(application) {

    // 뮤터블은 값을 수정, 삭제, 추가 가능
        private val _checkErrorIdText = MutableLiveData<Boolean>()
    val checkErrorIdText: MutableLiveData<Boolean> get() = _checkErrorIdText

    // private 을 get() 으로 초기화 한 이유
    // 객체지향의 캡슐화를 지키기 위해서다.



    fun checkId() {
        checkErrorIdText.value = true

    }
}

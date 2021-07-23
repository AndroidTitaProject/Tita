package com.example.tita.ui.fragment.signup.idPassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tita.data.network.dto.SignUpInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpIdPasswordViewModel @Inject constructor(
    private val repository: SignUpInterface
) : ViewModel() {

    private lateinit var _idText: MutableLiveData<Boolean>
    val idText: LiveData<Boolean> get() = _idText


}
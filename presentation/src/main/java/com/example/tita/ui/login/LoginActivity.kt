package com.example.tita.ui.login

import androidx.activity.viewModels
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : UtilityBase.BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val viewModel: LoginViewModel by viewModels<LoginViewModel>()


}
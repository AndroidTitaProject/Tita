package com.example.tita.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.tita.R
import com.example.tita.base.BaseActivity
import com.example.tita.databinding.ActivityLoginBinding
import com.example.tita.ui.fragment.SignUpCertificatioFragment
import com.example.tita.ui.fragment.SignUptermsFragment
import com.example.tita.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginActivity :
    BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutResID: Int
        get() = R.layout.activity_login

    override val viewModel: LoginViewModel
        get() = getViewModel(LoginViewModel::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this@LoginActivity

    }

    fun intentSignUp(view:View) {
        supportFragmentManager.beginTransaction().replace(
            R.id.login_layout,
            SignUptermsFragment()
        ).commit()

    }

}
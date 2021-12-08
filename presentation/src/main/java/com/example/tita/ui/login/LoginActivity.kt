package com.example.tita.ui.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : UtilityBase.BaseActivity<FragmentLoginBinding>(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.nextButton.setOnClickListener {
            lifecycleScope.launch {

                viewModel.login(
                    binding.idEdit.text.toString(),
                    binding.passwordEdit.text.toString()
                )
            }
        }
    }


    override fun FragmentLoginBinding.onCreate() {
    }
}
package com.example.tita.ui.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentLoginBinding
import com.example.tita.utils.EventObserver
import com.example.tita.utils.errorAnimationShow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : UtilityBase.BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels<LoginViewModel>()


    override fun FragmentLoginBinding.onCreateView() {

    }

    override fun FragmentLoginBinding.onViewCreated() {
        binding.signUpText.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_signUpTermsFragment)
        }
        with(viewModel) {
            binding.nextButton.setOnClickListener {
                lifecycleScope.launch {

                    login(
                        binding.idEdit.text.toString(),
                        binding.passwordEdit.text.toString()
                    )
                }
            }
            isSuccess.observe(viewLifecycleOwner, EventObserver {
                // TODO: 2021-12-15  intent main
            })
            // 로그인 실패
            isFailure.observe(viewLifecycleOwner, EventObserver {
                binding.forgetIdText.errorAnimationShow(requireContext(),binding.forgetIdText.text.toString())
                binding.forgotPasswordText.errorAnimationShow(requireContext(),binding.forgotPasswordText.text.toString())
            })
            binding.forgetIdText.setOnClickListener{

                findNavController().navigate(R.id.action_loginFragment_to_fragment_find_id)
            }
            binding.forgotPasswordText.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_find_password)

            }
        }
    }


}
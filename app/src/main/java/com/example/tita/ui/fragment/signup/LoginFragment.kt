package com.example.tita.ui.fragment.signup

import android.content.Intent
import android.view.View
import android.view.View.VISIBLE
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentLoginBinding
import com.example.tita.ui.activity.NavigationMainActivity
import com.example.tita.ui.fragment.login.LoginViewModel


class LoginFragment : UtilityBase.BaseFragment<FragmentLoginBinding>(R.layout.fragment_login), VIewInterface {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun FragmentLoginBinding.onCreateView() {
        binding.login = loginViewModel
        binding.fragment = this@LoginFragment


    }

    override fun FragmentLoginBinding.onViewCreated() {

    }



    override fun onclcik(v: View) {
        when (v) {
            binding.nextButton -> {
//                val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.find_id_password_effect)
//                binding.forgetIdBtn.visibility = VISIBLE
//                binding.forgetIdBtn.startAnimation(animation)
//                binding.findPasswordText.visibility = VISIBLE
//                binding.findPasswordText.startAnimation(animation)
                val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.find_id_password_effect)
                binding.forgetIdBtn.visibility = VISIBLE
                binding.forgetIdBtn.startAnimation(animation)
                binding.findPasswordText.visibility = VISIBLE
                binding.findPasswordText.startAnimation(animation)

                startActivity(Intent(requireContext(),NavigationMainActivity::class.java))
            }
            binding.forgetIdBtn ->
                findNavController().navigate(R.id.action_LoginFragment_to_findFragment)
            binding.signUpText -> {
                findNavController().navigate(R.id.action_LoginFragment_to_signUpTermsFragment)
            }

            binding.findPasswordText -> {
                findNavController().navigate(R.id.action_LoginFragment_to_findPasswordFragment)
            }


        }
    }


}
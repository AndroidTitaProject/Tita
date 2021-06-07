package com.example.tita.ui.fragment.signup

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tita.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tita.databinding.FragmentLoginBinding
import com.example.tita.ui.activity.NavigationMainActivity
import com.example.tita.ui.activity.SignUpMainActivity
import com.example.tita.viewmodels.LoginViewModel


class LoginFragment : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_login, container, false)
        binding.login = loginViewModel
        binding.fragment = this

        //toolbar 없애기
        (requireActivity() as SignUpMainActivity).supportActionBar!!.hide()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener(this)
        binding.findIdPwdText.setOnClickListener(this)
        binding.passwordEdit.setOnClickListener(this)
        binding.signUpText.setOnClickListener(this)
        binding.forgetIdBtn.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v) {
            binding.loginButton ->
                startActivity(Intent(requireContext(), NavigationMainActivity::class.java))
            binding.forgetIdBtn ->
                findNavController().navigate(R.id.action_LoginFragment_to_findFragment)
            binding.signUpText -> {
                findNavController().navigate(R.id.action_LoginFragment_to_signUpTermsFragment)
            }
            binding.findIdPwdText->{
                findNavController().navigate(R.id.action_LoginFragment_to_passwordChangeFragment)
            }

            binding.passwordEdit -> {
                Log.d(TAG, "onClick: password")
                binding.forgetIdBtn.visibility = VISIBLE
                binding.findIdPwdText.visibility = VISIBLE
            }

        }
    }

}
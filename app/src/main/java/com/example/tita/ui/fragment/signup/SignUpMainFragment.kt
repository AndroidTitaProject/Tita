package com.example.tita.ui.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.databinding.FragmentLoginBinding
import com.example.tita.databinding.FragmentSignUpMainBinding
import com.example.tita.viewmodels.LoginViewModel

class SignUpMainFragment : Fragment() {

    lateinit var binding: FragmentSignUpMainBinding
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_sign_up_main, container, false)
        binding.fragment = this

        return binding.root
    }

    fun oo(view: View) {
        findNavController().navigate(R.id.action_signUpMainFragment_to_LoginFragment)

    }
}
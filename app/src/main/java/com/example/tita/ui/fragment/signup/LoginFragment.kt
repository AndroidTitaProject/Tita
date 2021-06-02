package com.example.tita.ui.fragment.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tita.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tita.databinding.FragmentLoginBinding
import com.example.tita.ui.activity.NavigationMainActivity
import com.example.tita.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_login, container, false)
        binding.login = loginViewModel
        binding.fragment = this




        return binding.root
    }

    fun login(view: View) {
        startActivity(Intent(requireContext(), NavigationMainActivity::class.java))

    }
}
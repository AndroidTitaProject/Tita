package com.example.tita.ui.fragment.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpIdPasswordBinding
import com.example.tita.databinding.FragmentSignUpSetNameBinding

class SignUpSetNameFragment : UtilityBase.BaseFragment<FragmentSignUpSetNameBinding>(R.layout.fragment_sign_up_set_name), VIewInterface {

    override fun FragmentSignUpSetNameBinding.onCreateView() {
        binding.fragment = this@SignUpSetNameFragment
    }

    override fun FragmentSignUpSetNameBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpSetNameFragment_to_LoginFragment)
    }
}
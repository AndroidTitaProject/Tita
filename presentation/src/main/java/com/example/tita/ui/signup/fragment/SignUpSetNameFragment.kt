package com.example.tita.ui.signup.fragment

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpSetNameBinding

class SignUpSetNameFragment :
    UtilityBase.BaseFragment<FragmentSignUpSetNameBinding>(R.layout.fragment_sign_up_set_name),
    VIewInterface {


    override fun FragmentSignUpSetNameBinding.onCreateView() {

    }

    override fun FragmentSignUpSetNameBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpSetNameFragment_to_LoginFragment)
    }
}
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
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpIdPasswordBinding
import com.example.tita.viewmodels.LoginViewModel

class SignUpIdPasswordFragment : UtilityBase.BaseFragment<FragmentSignUpIdPasswordBinding>(R.layout.fragment_sign_up_id_password), VIewInterface {

    override fun FragmentSignUpIdPasswordBinding.onCreateView() {
        binding.fragment = this@SignUpIdPasswordFragment
    }

    override fun FragmentSignUpIdPasswordBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpIdPasswordFragment_to_signUpCertificatioSchoolFragment)
    }
}
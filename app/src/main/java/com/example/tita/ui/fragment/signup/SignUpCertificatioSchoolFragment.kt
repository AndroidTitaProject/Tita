package com.example.tita.ui.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpCertificatioSchoolBinding

class SignUpCertificatioSchoolFragment : UtilityBase.BaseFragment<FragmentSignUpCertificatioSchoolBinding>(R.layout.fragment_sign_up_certificatio_school), VIewInterface {


    override fun FragmentSignUpCertificatioSchoolBinding.onCreateView() {

        binding.fragment = this@SignUpCertificatioSchoolFragment
    }

    override fun FragmentSignUpCertificatioSchoolBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpCertificatioSchoolFragment_to_signUpSetNameFragment)
    }
}
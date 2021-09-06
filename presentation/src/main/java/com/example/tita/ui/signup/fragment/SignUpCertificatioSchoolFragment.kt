package com.example.tita.ui.signup.activity.signup

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpCertificatioSchoolBinding

class SignUpCertificatioSchoolFragment : UtilityBase.BaseFragment<FragmentSignUpCertificatioSchoolBinding>(R.layout.fragment_sign_up_certificatio_school), VIewInterface {


    override fun FragmentSignUpCertificatioSchoolBinding.onCreateView() {

    }

    override fun FragmentSignUpCertificatioSchoolBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpCertificatioSchoolFragment_to_signUpSetNameFragment)
    }
}
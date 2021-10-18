package com.example.tita.ui.signup.fragment

import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpCertificatioSchoolBinding

class SignUpCertificatioSchoolFragment : UtilityBase.BaseFragment<FragmentSignUpCertificatioSchoolBinding>(R.layout.fragment_sign_up_certificatio_school) {


    override fun FragmentSignUpCertificatioSchoolBinding.onCreateView() {

    }

    override fun FragmentSignUpCertificatioSchoolBinding.onViewCreated() {
        binding.nextBtn.setOnClickListener{
            findNavController().navigate(R.id.action_signUpCertificatioSchoolFragment_to_signUpSetNameFragment)
        }
    }

}
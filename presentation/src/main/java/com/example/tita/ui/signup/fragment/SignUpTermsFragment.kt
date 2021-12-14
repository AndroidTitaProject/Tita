package com.example.tita.ui.signup.fragment

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpTermsBinding

class SignUpTermsFragment :
    UtilityBase.BaseFragment<FragmentSignUpTermsBinding>(R.layout.fragment_sign_up_terms) {

    override fun FragmentSignUpTermsBinding.onCreateView() {
    }

    override fun FragmentSignUpTermsBinding.onViewCreated() {
        with(binding) {
            allCheckCheckbox.setOnClickListener {
                if (allCheckCheckbox.isChecked) {
                    communityTermsOfUseCheckbox.isChecked = true
                    informationProcessingCheckbox.isChecked = true
                    serviceCheckbox.isChecked = true
                } else {
                    communityTermsOfUseCheckbox.isChecked = false
                    informationProcessingCheckbox.isChecked = false
                    serviceCheckbox.isChecked = false
                }
            }
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
            nextButton.setOnClickListener {
                if (checkBoxChecked()) {
                    findNavController().navigate(R.id.action_signUpTermsFragment_to_signUpCertificatioFragment)
                } else {
                    Toast.makeText(requireContext(), "빈칸을 빠짐없이 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }

    private fun checkBoxChecked() =
        binding.communityTermsOfUseCheckbox.isChecked && binding.informationProcessingCheckbox.isChecked && binding.serviceCheckbox.isChecked
}
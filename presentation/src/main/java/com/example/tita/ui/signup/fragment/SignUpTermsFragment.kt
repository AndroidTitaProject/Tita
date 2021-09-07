package com.example.tita.ui.signup.fragment

import android.widget.CheckBox
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpTermsBinding
import com.example.tita.utils.errorAnimationShow

class SignUpTermsFragment :
    UtilityBase.BaseFragment<FragmentSignUpTermsBinding>(R.layout.fragment_sign_up_terms) {

    private val allCheckBox: CheckBox by lazy {
        binding.allCheckCheckbox
    }
    private val serviceCheckBox: CheckBox by lazy {
        binding.serviceCheckbox
    }
    private val processCheckBox: CheckBox by lazy {
        binding.informationProcessingCheckbox
    }
    private val communityCheckbox: CheckBox by lazy {
        binding.communityTermsOfUseCheckbox
    }

    override fun FragmentSignUpTermsBinding.onCreateView() {

        checkBoxSelect()
        checkBoxSuccess()
    }

    override fun FragmentSignUpTermsBinding.onViewCreated() {
    }


    private fun checkBoxSelect() {

        allCheckBox.setOnClickListener {
            serviceCheckBox.isChecked=true
            processCheckBox.isChecked=true
            communityCheckbox.isChecked=true

            if(!allCheckBox.isChecked){
                serviceCheckBox.isChecked=false
                processCheckBox.isChecked=false
                communityCheckbox.isChecked=false
            }
        }



    }

    private fun checkBoxSuccess() {

        binding.nextButton.setOnClickListener {
            if (serviceCheckBox.isChecked && processCheckBox.isChecked && communityCheckbox.isChecked)
                findNavController().navigate(R.id.action_signUpTermsFragment_to_signUpCertificatioFragment)
            else
                binding.errorText.errorAnimationShow(requireContext(), "필수 항목이 동의되지 않았습니다.")
        }
    }

}
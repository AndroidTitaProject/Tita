package com.example.tita.ui.fragment.signup

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.CompoundButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpTermsBinding
import com.example.tita.util.textAnimation

class SignUpTermsFragment :
    UtilityBase.BaseFragment<FragmentSignUpTermsBinding>(R.layout.fragment_sign_up_terms),
    VIewInterface {
    lateinit var listener: CompoundButton.OnCheckedChangeListener
    override fun FragmentSignUpTermsBinding.onCreateView() {
        checkboxChoose()

    }

    override fun FragmentSignUpTermsBinding.onViewCreated() {

        binding.fragment = this@SignUpTermsFragment
        serviceCheckbox.setOnCheckedChangeListener(listener)
        allCheckCheckbox.setOnCheckedChangeListener(listener)
        informationProcessingCheckbox.setOnCheckedChangeListener(listener)
        communityTermsOfUseCheckbox.setOnCheckedChangeListener(listener)

    }


    private fun checkboxChoose() {
        listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

            when (buttonView) {
                binding.allCheckCheckbox -> {
                    binding.serviceCheckbox.isChecked = true
                    binding.informationProcessingCheckbox.isChecked = true
                    binding.communityTermsOfUseCheckbox.isChecked = true
                }
                binding.serviceCheckbox -> {

                }
                binding.informationProcessingCheckbox -> {
                }
                binding.informationProcessingCheckbox -> {
                }

            }

        }

    }

    override fun onclcik(v: View) {

        // 하드코딩.
        if (binding.serviceCheckbox.isChecked && binding.informationProcessingCheckbox.isChecked && binding.communityTermsOfUseCheckbox.isChecked) {
            findNavController().navigate(R.id.action_signUpTermsFragment_to_signUpCertificatioFragment)
        } else {
            textAnimation(binding.errorText, requireContext(), R.anim.shake_error_text)
        }
    }



}
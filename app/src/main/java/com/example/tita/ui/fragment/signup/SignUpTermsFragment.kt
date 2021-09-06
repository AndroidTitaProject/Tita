package com.example.tita.ui.fragment.signup

import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpTermsBinding

class SignUpTermsFragment : UtilityBase.BaseFragment<FragmentSignUpTermsBinding>(R.layout.fragment_sign_up_terms),VIewInterface {

    override fun FragmentSignUpTermsBinding.onCreateView() {
        binding.fragment = this@SignUpTermsFragment
    }

    override fun FragmentSignUpTermsBinding.onViewCreated() {
    }


    override fun onclcik(v: View) {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.shake_error_text)
        binding.errorText.visibility = View.VISIBLE
        binding.errorText.startAnimation(animation)

        findNavController().navigate(R.id.action_signUpTermsFragment_to_signUpCertificatioFragment)
    }


}
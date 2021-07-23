package com.example.tita.ui.fragment.signup.idPassword

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpIdPasswordBinding


class SignUpIdPasswordFragment : UtilityBase.BaseFragment<FragmentSignUpIdPasswordBinding>(R.layout.fragment_sign_up_id_password), VIewInterface {

    private val viewModel : SignUpIdPasswordViewModel by viewModels()

    override fun FragmentSignUpIdPasswordBinding.onCreateView() {
        binding.fragment = this@SignUpIdPasswordFragment
    }

    override fun FragmentSignUpIdPasswordBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpIdPasswordFragment_to_signUpCertificatioSchoolFragment)
    }



}
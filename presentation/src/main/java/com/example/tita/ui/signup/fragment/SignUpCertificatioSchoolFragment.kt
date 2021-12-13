package com.example.tita.ui.signup.fragment

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpCertificatioSchoolBinding
import com.example.tita.ui.signup.fragment.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpCertificatioSchoolFragment :
    UtilityBase.BaseFragment<FragmentSignUpCertificatioSchoolBinding>(R.layout.fragment_sign_up_certificatio_school) {

    private val args by navArgs<SignUpCertificatioSchoolFragmentArgs>()
    private val viewModel: SignUpViewModel by activityViewModels()
    override fun FragmentSignUpCertificatioSchoolBinding.onCreateView() {

    }

    override fun FragmentSignUpCertificatioSchoolBinding.onViewCreated() {
        getSchoolName()
        with(binding) {
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
            nextBtn.setOnClickListener {
                if (binding.schoolEdit.text.toString().isNotEmpty()) {
                    findNavController().navigate(R.id.action_signUpCertificatioSchoolFragment_to_signUpSetNameFragment)
                } else {
                    Toast.makeText(requireContext(), "학교를 검색해 주세요", Toast.LENGTH_SHORT).show()
                }
            }
            schoolButton.setOnClickListener {
                findNavController().navigate(R.id.action_signUpCertificatioSchoolFragment_to_searchSchoolFragment)
            }
        }
    }

    private fun getSchoolName() {
        if (args.schoolName.isNotEmpty()) {
            binding.schoolEdit.setText(args.schoolName)
            viewModel.getSchoolName(args.schoolName)
        }
    }

}
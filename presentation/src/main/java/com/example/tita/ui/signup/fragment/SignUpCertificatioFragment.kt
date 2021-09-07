package com.example.tita.ui.signup.fragment


import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentCertificatioBinding
import com.example.tita.ui.signup.fragment.viewmodel.SignUpViewModel
import com.example.tita.utils.EventObserver
import com.example.tita.utils.errorAnimationShow
import com.example.tita.utils.successAnimationShow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpCertificatioFragment :
    UtilityBase.BaseFragment<FragmentCertificatioBinding>(R.layout.fragment_certificatio) {

    private val viewModel by viewModels<SignUpViewModel>()
    override fun FragmentCertificatioBinding.onCreateView() {

        observeSuccess()
        observeFail()
        observeGetMail()
    }

    override fun FragmentCertificatioBinding.onViewCreated() {
    }

    private fun observeGetMail() {

        lifecycleScope.launch {
            viewModel.getMail(binding.emailEdit.text.toString())
        }
    }

    private fun observeSuccess() {
        lifecycleScope.launch {
            viewModel.isFailure.observe(viewLifecycleOwner, EventObserver {

                binding.errorSuccessEmailText.successAnimationShow(requireContext(), it)

            })
        }

    }

    private fun observeFail() {
        lifecycleScope.launch {

            viewModel.isSuccess.observe(viewLifecycleOwner, EventObserver {
                binding.errorSuccessEmailText.errorAnimationShow(requireContext(), it)
            })
        }
    }


}











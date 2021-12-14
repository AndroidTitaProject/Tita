package com.example.tita.ui.signup.fragment


import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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

    private val viewModel by activityViewModels<SignUpViewModel>()
    override fun FragmentCertificatioBinding.onCreateView() {


    }

    override fun FragmentCertificatioBinding.onViewCreated() {
        observeSuccess()
        observeFail()
        observeGetMail()
        nextBtnOnClick()
        with(binding) {
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun observeGetMail() {

        binding.emailBtn.setOnClickListener {
            lifecycleScope.launch {
                if (binding.emailEdit.text.toString().isNotBlank()) {
                    viewModel.getEmail(binding.emailEdit.text.toString())
                }else{
                    binding.errorSuccessEmailText.errorAnimationShow(requireContext(), "빈칸없이 적어주세요.")
                }
            }
        }
    }

    private fun observeSuccess() {
        lifecycleScope.launch {
            viewModel.isFailure.observe(viewLifecycleOwner, EventObserver {

                binding.errorSuccessEmailText.errorAnimationShow(requireContext(), it)

            })
        }

    }

    private fun observeFail() {
        lifecycleScope.launch {

            viewModel.isSuccess.observe(viewLifecycleOwner, EventObserver {
                binding.errorSuccessEmailText.successAnimationShow(requireContext(), it)
            })
        }
    }

    private fun nextBtnOnClick() {
        binding.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpCertificatioFragment_to_signUpMainFragment)
        }
    }


}











package com.example.tita.ui.signup.fragment

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpIdPasswordBinding
import com.example.tita.ui.signup.fragment.viewmodel.SignUpViewModel
import com.example.tita.utils.EventObserver
import com.example.tita.utils.errorAnimationShow
import com.example.tita.utils.successAnimationShow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpIdPasswordFragment :
    UtilityBase.BaseFragment<FragmentSignUpIdPasswordBinding>(R.layout.fragment_sign_up_id_password) {


    private val viewModel: SignUpViewModel by activityViewModels()
    override fun FragmentSignUpIdPasswordBinding.onCreateView() {
    }

    override fun FragmentSignUpIdPasswordBinding.onViewCreated() {

        with(viewModel) {
            binding.idBtn.setOnClickListener {
                lifecycleScope.launch {
                    if (binding.idEdit.text.toString().replace(" ", "").isNotEmpty()) {
                        // 아이디
                        viewModel.idCheck(binding.idEdit.text.toString())
                    } else {
                        binding.errorSuccessIdText.errorAnimationShow(
                            requireContext(),
                            "빈칸없이 적어주세요."
                        )
                    }
                }
                lifecycleScope.launch {

                    viewModel.isFailure.observe(viewLifecycleOwner, EventObserver {
                        binding.errorSuccessIdText.errorAnimationShow(requireContext(), it)
                    })
                }
                lifecycleScope.launch {
                    viewModel.isSuccess.observe(viewLifecycleOwner, EventObserver {
                        binding.errorSuccessIdText.successAnimationShow(requireContext(), it)

                    })
                }
            }
            successImport()
        }

    }

    fun passwordEquals(): Boolean {
        return if (binding.passwordEdit.text.toString().isEmpty()) {
            return false
        } else {
            return binding.passwordEdit.text.toString() == binding.passwordOkEdit.text.toString()

        }
    }


    fun successImport() {
        binding.nextBtn.setOnClickListener {
            if (viewModel.isSuccess.value.toString().isNotEmpty()) {
                if (passwordEquals()) {
                    Log.d("TAG", "successImport: ")
                    viewModel.getPassword(binding.passwordOkEdit.text.toString())
                    findNavController().navigate(R.id.action_signUpIdPasswordFragment_to_signUpCertificatioSchoolFragment)
                } else {
                    Toast.makeText(context, "비밀번호가 옳지 않습니다.", Toast.LENGTH_SHORT).show()
                    Log.d("TAG", "successImport: else ")
                }
            }
        }
    }

}
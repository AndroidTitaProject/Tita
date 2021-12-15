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

    var success = ""

    private val viewModel: SignUpViewModel by activityViewModels()
    override fun FragmentSignUpIdPasswordBinding.onCreateView() {
    }

    override fun FragmentSignUpIdPasswordBinding.onViewCreated() {

        with(viewModel) {
            binding.idBtn.setOnClickListener {
                lifecycleScope.launch {
                    if (isFormat(binding.idEdit.text.toString().trim())) {
                        // 아이디
                        viewModel.idCheck(binding.idEdit.text.toString())
                    } else {
                        binding.errorSuccessIdText.errorAnimationShow(
                            requireContext(),
                            "규칙에 맞게 적어주세요."
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
                        viewModel.getUserName(binding.idEdit.text.toString())
                        success = it
                        binding.errorSuccessIdText.successAnimationShow(requireContext(), it)

                    })
                }
            }

            with(binding) {
                backBtn.setOnClickListener {
                    findNavController().navigateUp()
                }
            }
            successImport()
        }

    }

    private fun passwordEquals(): Boolean {
        return if (binding.passwordEditEdit.text.toString().isEmpty()) {
            return false
        } else {
            return binding.passwordEditEdit.text.toString() == binding.passwordOkEdit.text.toString()

        }
    }

    private fun isPasswordFormat(password: String): Boolean {
        return password.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{7,15}.$".toRegex())
    }

    private fun isFormat(id: String): Boolean {
        return id.matches("^(?=.*[A-Za-z])(?=.*[0-9]).{5,16}.\$".toRegex())
    }


    private fun successImport() {
        binding.nextBtn.setOnClickListener {
            Log.d("TAG", "successTest: ${success == "성공하였습니디."}")
            Log.d("TAG", "successTest success: ${success.isNotEmpty()}")
            Log.d("TAG", "정규식 테스트: ${isPasswordFormat(binding.passwordEditEdit.text.toString())}")
            Log.d("TAG", "비밀번호 같은지 테스트: ${passwordEquals()}")
            if (success.isNotEmpty() && isPasswordFormat(binding.passwordEditEdit.text.toString()) && passwordEquals()
            ) {
                Log.d("TAG", "successImport: ")
                viewModel.getPassword(binding.passwordOkEdit.text.toString())

                findNavController().navigate(R.id.action_signUpIdPasswordFragment_to_signUpCertificatioSchoolFragment)

            } else {
                Toast.makeText(requireContext(), "다시 확인해 주세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
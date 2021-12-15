package com.example.tita.ui.signup.fragment

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpSetNameBinding
import com.example.tita.ui.signup.fragment.viewmodel.SignUpViewModel
import com.example.tita.utils.EventObserver
import com.example.tita.utils.errorAnimationShow
import com.example.tita.utils.successAnimationShow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint

class SignUpSetNameFragment :
    UtilityBase.BaseFragment<FragmentSignUpSetNameBinding>(R.layout.fragment_sign_up_set_name) {
    var success = ""

    private val viewModel by activityViewModels<SignUpViewModel>()
    override fun FragmentSignUpSetNameBinding.onCreateView() {

    }

    override fun FragmentSignUpSetNameBinding.onViewCreated() {
        with(viewModel) {
            binding.nickNameBtn.setOnClickListener {
                Log.d("TAG", "onViewCreated: name")
                lifecycleScope.launch {
                    viewModel.nickNameOverlap(binding.nicknameEdit.text.toString())
                }
            }
            lifecycleScope.launch {

                viewModel.isFailure.observe(viewLifecycleOwner, EventObserver {
                    Log.d("TAG", "onViewCreated: fall $it")
                    binding.returnText.errorAnimationShow(requireContext(), it)
                })
            }
            lifecycleScope.launch {
                viewModel.isSuccess.observe(viewLifecycleOwner, EventObserver {
                    success = it
                    Log.d("TAG", "onViewCreated: success $it")
                    binding.returnText.successAnimationShow(requireContext(), it)

                })
            }
            isSignSuccess.observe(viewLifecycleOwner, EventObserver {
                if (it == successSignUp) {
                    Log.d(TAG, "onViewCreated: ${it}")
                    findNavController().navigate(R.id.action_signUpSetNameFragment_to_loginFragment)
                } else {
                    Toast.makeText(requireContext(), "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            })
        }

        binding.nextButton.setOnClickListener {
            lifecycleScope.launch {
                if (success.isNotEmpty()) {
                    viewModel.signUp(binding.nicknameEdit.text.toString())
                } else {
                }
            }
        }
        with(binding) {
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
    companion object{
        const val successSignUp="회원가입 성공"
    }
}



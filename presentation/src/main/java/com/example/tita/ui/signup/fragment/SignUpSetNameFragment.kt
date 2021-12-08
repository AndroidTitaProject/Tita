package com.example.tita.ui.signup.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
                    Log.d("TAG", "onViewCreated: success $it")
                    binding.returnText.successAnimationShow(requireContext(), it)

                })
            }
        }

        binding.nextButton.setOnClickListener {
            lifecycleScope.launch {
                if (viewModel.isSuccess.value.toString().isNotEmpty()) {
                    viewModel.signUp(binding.nicknameEdit.text.toString())
                }
            }
        }
    }
}



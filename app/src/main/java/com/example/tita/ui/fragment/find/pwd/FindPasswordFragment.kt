package com.example.tita.ui.fragment.find.pwd

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindPasswordBinding
import com.example.tita.viewmodels.SignUpViewModel
import androidx.fragment.app.viewModels

class FindPasswordFragment :
    UtilityBase.BaseFragment<FragmentFindPasswordBinding>(R.layout.fragment_find_password),
    VIewInterface {

    private val signUpViewModel: SignUpViewModel by viewModels()
    override fun FragmentFindPasswordBinding.onCreateView() {
        binding.fragment = this@FindPasswordFragment
        binding.viewModel = signUpViewModel
        successToAnimEmail()

    }

    override fun FragmentFindPasswordBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        signUpViewModel.checkPasswordErrorIdText.observe(viewLifecycleOwner, {


        })
        findNavController().navigate(R.id.action_findPasswordFragment_to_passwordChangeFragment)
    }

    private fun successToAnimEmail() {
        signUpViewModel.checkErrorEmail.observe(viewLifecycleOwner, {
            Log.d(TAG, "checkError: $it")
            if (it == true){
                binding.errorEmailText.startAnimation(
                    AnimationUtils.loadAnimation(
                        requireContext(),
                        R.anim.authentication_success_bunce

                    )
                )}

        })

        signUpViewModel.checkErrorCer.observe(viewLifecycleOwner, {
            Log.d(TAG, "checkError: $it")
            if(it==true)
            binding.errorCerPasswordText.startAnimation(
                AnimationUtils.loadAnimation(
                    requireContext(),
                    R.anim.authentication_success_bunce

                )
            )
        })
    }
}
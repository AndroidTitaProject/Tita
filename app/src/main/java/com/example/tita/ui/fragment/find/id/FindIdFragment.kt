package com.example.tita.ui.fragment.find.id

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindIdBinding
import com.example.tita.viewmodels.SignUpViewModel

class FindIdFragment : UtilityBase.BaseFragment<FragmentFindIdBinding>(R.layout.fragment_find_id),
    VIewInterface {

    private val signUpViewModel: SignUpViewModel by viewModels()


    override fun FragmentFindIdBinding.onCreateView() {
        successToAnimEmail()
    }

    override fun FragmentFindIdBinding.onViewCreated() {
        binding.fragment = this@FindIdFragment
        binding.viewModel = signUpViewModel
        binding.lifecycleOwner = this@FindIdFragment
    }


    // 계정이 없을 때 뜬다.
    private fun successToAnimEmail() {

        signUpViewModel.checkErrorIdText.observe(
            viewLifecycleOwner, Observer {
                if (it == true) {
                    Log.d(TAG, "successToAnimEmail: ")
                    binding.errorFindIdText.startAnimation(
                        AnimationUtils.loadAnimation(
                            requireContext(),
                            R.anim.authentication_success_bunce

                        )
                    )
                }
            }
        )

    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_findIdFragment_to_findIdNowFragment)
    }
}
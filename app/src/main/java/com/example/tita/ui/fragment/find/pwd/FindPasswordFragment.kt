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
import com.example.tita.ui.fragment.signup.cetificatio.SignUpViewModel
import androidx.fragment.app.viewModels

class FindPasswordFragment :
    UtilityBase.BaseFragment<FragmentFindPasswordBinding>(R.layout.fragment_find_password),
    VIewInterface {

    private val signUpViewModel: SignUpViewModel by viewModels()
    override fun FragmentFindPasswordBinding.onCreateView() {
        binding.fragment = this@FindPasswordFragment
        binding.viewModel = signUpViewModel
        binding.lifecycleOwner = this@FindPasswordFragment

    }

    override fun FragmentFindPasswordBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {


    }


}

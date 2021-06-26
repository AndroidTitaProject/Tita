package com.example.tita.ui.fragment.find.pwd

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindPasswordBinding
import com.example.tita.viewmodels.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FindPasswordFragment : UtilityBase.BaseFragment<FragmentFindPasswordBinding>(R.layout.fragment_find_password), VIewInterface {

    private val signUpViewModel:SignUpViewModel by viewModel()
    override fun FragmentFindPasswordBinding.onCreateView() {

        binding.fragment=this@FindPasswordFragment
        binding.viewModel=signUpViewModel
    }

    override fun FragmentFindPasswordBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        signUpViewModel.checkPasswordErrorIdText.observe(viewLifecycleOwner,{
            if(it==false)
                findNavController().navigate(R.id.action_findPasswordFragment_to_passwordChangeFragment)

        })
    }
}
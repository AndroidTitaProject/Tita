package com.example.tita.ui.fragment.find.pwd

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindPasswordChangeFinishBinding

class FindPasswordChangeFinishFragment : UtilityBase.BaseFragment<FragmentFindPasswordChangeFinishBinding>(R.layout.fragment_find_password_change_finish)
,VIewInterface{
    override fun FragmentFindPasswordChangeFinishBinding.onCreateView() {

        binding.fragment = this@FindPasswordChangeFinishFragment
    }

    override fun FragmentFindPasswordChangeFinishBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {

        findNavController().navigate(R.id.action_passwordChangeFinishFragment_to_LoginFragment)
    }
}
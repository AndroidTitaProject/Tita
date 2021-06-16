package com.example.tita.ui.fragment.find.pwd

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindPasswordBinding

class FindPasswordFragment : UtilityBase.BaseFragment<FragmentFindPasswordBinding>(R.layout.fragment_find_password), VIewInterface {

    override fun FragmentFindPasswordBinding.onCreateView() {

        binding.fragment=this@FindPasswordFragment
    }

    override fun FragmentFindPasswordBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_findPasswordFragment_to_passwordChangeFragment)
    }
}
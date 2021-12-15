package com.example.tita.ui.fragment.find.pwd

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindPasswordChangeBinding

class FindPasswordChangeFragment : UtilityBase.BaseFragment<FragmentFindPasswordChangeBinding>(R.layout.fragment_find_password_change), VIewInterface {

    override fun FragmentFindPasswordChangeBinding.onCreateView() {

        binding.fragment = this@FindPasswordChangeFragment
    }

    override fun FragmentFindPasswordChangeBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_passwordChangeFragment_to_passwordChangeFinishFragment)
    }
}
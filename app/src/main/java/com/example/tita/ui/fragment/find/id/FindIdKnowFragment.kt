package com.example.tita.ui.fragment.find.id

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentFindIdKnowBinding

class FindIdKnowFragment : UtilityBase.BaseFragment<FragmentFindIdKnowBinding>(R.layout.fragment_find_id_know), VIewInterface {


    override fun FragmentFindIdKnowBinding.onCreateView() {

        binding.fragment = this@FindIdKnowFragment
    }

    override fun FragmentFindIdKnowBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_findIdNowFragment_to_LoginFragment)
    }
}
package com.example.tita.ui.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.databinding.FragmentFindIdKnowBinding

class FragmentIdKnowFragment : Fragment(), VIewInterface {


    lateinit var binding: FragmentFindIdKnowBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_find_id_know, container, false)
        binding.fragment = this
        return binding.root

    }


    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_findIdNowFragment_to_LoginFragment)
    }
}
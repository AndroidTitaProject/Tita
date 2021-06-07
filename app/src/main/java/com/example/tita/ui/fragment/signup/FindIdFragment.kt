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
import com.example.tita.databinding.FragmentFindIdBinding
import com.example.tita.databinding.FragmentLoginBinding

class FindIdFragment : Fragment(),VIewInterface {

    lateinit var binding: FragmentFindIdBinding
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        val binding: FragmentFindIdBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_find_id, container, false)


        binding.fragment = this




        return binding.root
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_findIdFragment_to_findIdNowFragment)
    }
}
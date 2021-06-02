package com.example.tita.ui.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tita.R
import com.example.tita.databinding.FragmentFindIdBinding
import com.example.tita.databinding.FragmentLoginBinding

class FindFragment : Fragment() {

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
}
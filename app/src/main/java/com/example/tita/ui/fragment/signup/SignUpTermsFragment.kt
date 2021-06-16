package com.example.tita.ui.fragment.signup

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.databinding.FragmentFindIdBinding
import com.example.tita.databinding.FragmentSignUpTermsBinding

class SignUpTermsFragment : Fragment() {

    lateinit var binding: FragmentSignUpTermsBinding
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {

        val binding: FragmentSignUpTermsBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_sign_up_terms, container, false)
        binding.fragment = this

        return binding.root
    }

    fun onclick(v:View){
        findNavController().navigate(R.id.action_signUpTermsFragment_to_signUpIdPasswordFragment)
    }


}
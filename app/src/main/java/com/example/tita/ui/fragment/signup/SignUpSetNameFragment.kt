package com.example.tita.ui.fragment.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.databinding.FragmentSignUpIdPasswordBinding
import com.example.tita.databinding.FragmentSignUpSetNameBinding

class SignUpSetNameFragment : Fragment(),VIewInterface {

    lateinit var binding: FragmentSignUpSetNameBinding
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_sign_up_set_name, container, false)
        binding.fragment = this

        return binding.root
    }



    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpsetnameFragment_to_LoginFragment)
    }
}
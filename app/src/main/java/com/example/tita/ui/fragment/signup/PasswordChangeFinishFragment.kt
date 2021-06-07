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
import com.example.tita.databinding.FragmentPasswordChangeBinding
import com.example.tita.databinding.FragmentPasswordChangeFinishBinding

class PasswordChangeFinishFragment : Fragment(),VIewInterface {

    lateinit var binding: FragmentPasswordChangeFinishBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_password_change_finish, container, false)
        binding.fragment = this
        return binding.root

    }


    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_passwordChangeFinishFragment_to_LoginFragment)
    }
}
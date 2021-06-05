package com.example.tita.ui.fragment.signup


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.databinding.FragmentCertificatioBinding
import com.example.tita.databinding.FragmentSignUpMainBinding

class SignUpCertificatioFragment : Fragment() {

    lateinit var binding: FragmentCertificatioBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_certificatio, container, false)
        binding.fragment = this
        return binding.root

    }
    fun dd(view:View){
        findNavController().navigate(R.id.action_signUpCertificatioFragment_to_signUpMainFragment)
    }


}




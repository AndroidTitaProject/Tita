package com.example.tita.ui.fragment

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.base.BaseFragment
import com.example.tita.databinding.FragmentSignUpBinding
import com.example.tita.viewmodels.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SignUptermsFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>() {
    override val layoutResID: Int
        get() = R.layout.fragment_sign_up

    override val viewModel: SignUpViewModel
        get() = getViewModel(SignUpViewModel::class)


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?

    ): FragmentSignUpBinding {
        return FragmentSignUpBinding.inflate(inflater, container, false)
    }

    fun intentSignUpTerms(view: View) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.sign_Up_text,
            SignUpCertificatioFragment()
        )?.commit()
    }

}
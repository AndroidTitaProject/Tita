package com.example.tita.ui.signup.fragment


import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentCertificatioBinding

class SignUpCertificatioFragment : UtilityBase.BaseFragment<FragmentCertificatioBinding>(R.layout.fragment_certificatio),VIewInterface {


    override fun FragmentCertificatioBinding.onCreateView() {
    }

    override fun FragmentCertificatioBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {

        findNavController().navigate(R.id.action_signUpCertificatioFragment_to_signUpMainFragment)

    }






}




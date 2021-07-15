package com.example.tita.ui.fragment.signup

import android.graphics.Color
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentSignUpIdPasswordBinding

class SignUpIdPasswordFragment : UtilityBase.BaseFragment<FragmentSignUpIdPasswordBinding>(R.layout.fragment_sign_up_id_password), VIewInterface {

    var num1 : Int = 1

    override fun FragmentSignUpIdPasswordBinding.onCreateView() {
        binding.fragment = this@SignUpIdPasswordFragment
    }

    override fun FragmentSignUpIdPasswordBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        findNavController().navigate(R.id.action_signUpIdPasswordFragment_to_signUpCertificatioSchoolFragment)
    }

    fun onclickSuccessId(v: View){
        num1++
        if(num1%2==0) successToAnimEmail()
        else failToAnimEmail()
    }

    fun successToAnimEmail(){
        binding.errorSuccessIdText.text = "사용가능한 아이디입니다."
        binding.errorSuccessIdText.setTextColor(Color.parseColor("#000000"))
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.authentication_success_bunce)
        binding.errorSuccessIdText.visibility = View.VISIBLE
        binding.errorSuccessIdText.startAnimation(animation)
    }

    fun failToAnimEmail(){
        binding.errorSuccessIdText.text = "이미 존재하는 아이디입니다."
        binding.errorSuccessIdText.setTextColor(Color.parseColor("#DB4040"))
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.shake_error_text)
        binding.errorSuccessIdText.visibility = View.VISIBLE
        binding.errorSuccessIdText.startAnimation(animation)
    }
}
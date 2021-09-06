package com.example.tita.ui.fragment.signup


import android.graphics.Color
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentCertificatioBinding
import org.koin.android.ext.android.bind

class SignUpCertificatioFragment : UtilityBase.BaseFragment<FragmentCertificatioBinding>(R.layout.fragment_certificatio),VIewInterface {

    var num : Int = 1
    var num1 : Int = 1

    override fun FragmentCertificatioBinding.onCreateView() {
        binding.fragment=this@SignUpCertificatioFragment
    }

    override fun FragmentCertificatioBinding.onViewCreated() {
    }

    override fun onclcik(v: View) {
        // 세가지 경우
        // 계속하기를 먼저 눌렀을때 예외처리
        // 인증번호 보내기를 아무것도 안쓰고 눌렀을때 예외처리
        // 이메일을 바꿀경우 다시 이멜을 잘못쳤을때 예외처리

        //        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.shake_error_text)
        //        binding.errorText.visibility = View.VISIBLE
        //        binding.errorText.startAnimation(animation)
        findNavController().navigate(R.id.action_signUpCertificatioFragment_to_signUpMainFragment)

    }

    fun CertificatioemailOnclick(v: View){

        //임시, 누룰때마다 글씨 변경
        num++
        if(num%2==0) successToAnimEmail()
        else failToAnimEmail()

    }

    fun CertificatioNumberOnclick(v: View){

        //임시, 누룰때마다 글씨 변경
        num1++
        if(num1%2==0) successToAnimNumber()
        else failToAnimNumber()

    }

    fun successToAnimEmail(){
        binding.errorSuccessEmailText.text = "인증번호가 전송되었습니다."
        binding.errorSuccessEmailText.setTextColor(Color.parseColor("#000000"))
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.authentication_success_bunce)
        binding.errorSuccessEmailText.visibility = View.VISIBLE
        binding.errorSuccessEmailText.startAnimation(animation)
    }

    fun failToAnimEmail(){
        binding.errorSuccessEmailText.text = "이메일 형식이 잘못되었습니다."
        binding.errorSuccessEmailText.setTextColor(Color.parseColor("#DB4040"))
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.shake_error_text)
        binding.errorSuccessEmailText.visibility = View.VISIBLE
        binding.errorSuccessEmailText.startAnimation(animation)
    }

    fun failToAnimNumber(){
        binding.errorSuccessNumberText.text = "잘못된 인증번호입니다."
        binding.errorSuccessNumberText.setTextColor(Color.parseColor("#DB4040"))
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.shake_error_text)
        binding.errorSuccessNumberText.visibility = View.VISIBLE
        binding.errorSuccessNumberText.startAnimation(animation)
    }

    fun successToAnimNumber(){
        binding.errorSuccessNumberText.text = "인증되었습니다."
        binding.errorSuccessNumberText.setTextColor(Color.parseColor("#000000"))
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.authentication_success_bunce)
        binding.errorSuccessNumberText.visibility = View.VISIBLE
        binding.errorSuccessNumberText.startAnimation(animation)
    }


}




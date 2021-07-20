package com.example.tita.ui.fragment.signup


import android.content.Intent
import android.text.TextUtils.isEmpty
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.Resource
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentCertificatioBinding
import com.example.tita.ui.fragment.signup.viewmodel.SignUpViewModel
import com.example.tita.util.textAnimation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpCertificatioFragment :
    UtilityBase.BaseFragment<FragmentCertificatioBinding>(R.layout.fragment_certificatio),
    VIewInterface {

    private val viewModel: SignUpViewModel by viewModels()

    override fun FragmentCertificatioBinding.onCreateView() {
        textSuccess()
        nullCheckCertificatio()

    }

    override fun FragmentCertificatioBinding.onViewCreated() {
        binding.fragment = this@SignUpCertificatioFragment
    }

    override fun onclcik(v: View) {
        // 세가지 경우
        // 계속하기를 먼저 눌렀을때 예외처리
        // 인증번호 보내기를 아무것도 안쓰고 눌렀을때 예외처리
        // 이메일을 바꿀경우 다시 이멜을 잘못쳤을때 예외처리

        findNavController().navigate(R.id.action_signUpCertificatioFragment_to_signUpMainFragment)
    }


    private fun textSuccess(){
        viewModel.mailText.observe(viewLifecycleOwner, Observer { mail ->
            viewModel.checkMail.observe(viewLifecycleOwner, Observer {
                if (it == true) {
                    when (mail) {

                        "인증번호가 전송되었습니다" -> {
                            binding.errorSuccessEmailText.text = mail
                            textAnimation(
                                binding.errorSuccessEmailText,
                                requireContext(),
                                R.anim.success_bow_roate
                            )
                        }
                        "이메일 형식이 잘못되었습니다." -> {
                            binding.errorSuccessEmailText.text = mail
                            textAnimation(
                                binding.errorSuccessEmailText,
                                requireContext(),
                                R.anim.shake_error_text
                            )


                        }
                    }

                }
            })

        })
    }
     fun nullCheckCertificatio() {



            // 메일을 보내 값이 성공하면 성공된 값을 리턴, 그러면 숫자가 나옫겠지? 그 숫자랑 인증번호랑 비교해서 같으면 성공 틀리면 다시 하라고 Toast
            viewModel.mailSend(binding.emailEdit.text.toString())
            viewModel.postMail.observe(viewLifecycleOwner, Observer { response ->
                when (response) {
                    is Resource.Success -> {
                        binding.certificationNumberButton.setOnClickListener {
                            response.data?.mail.let {
                                if (it == binding.certificationNumberEdit.text.toString()) {
                                    binding.errorSuccessNumberText.text="인증되었습니다."
                                    textAnimation(
                                        binding.errorSuccessNumberText,
                                        requireContext(),
                                        R.anim.success_bow_roate
                                    )

                                }else{
                                    binding.errorSuccessNumberText.text="잘못된 인증번호입니다."
                                    textAnimation(
                                        binding.errorSuccessNumberText,
                                        requireContext(),
                                        R.anim.shake_error_text
                                    )
                                }
                            }
                        }
                    }
                    else -> Log.d("signup", "nullCheckCertificatio: ")
                }
            })

        }


}








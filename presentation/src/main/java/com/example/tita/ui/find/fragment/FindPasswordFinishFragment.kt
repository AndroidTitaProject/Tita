package com.example.tita.ui.find.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.tita.R
import com.example.tita.databinding.FragmentFindPasswordChangeBinding
import com.example.tita.ui.find.fragment.viewmodel.FindIdPasswordViewModel
import com.example.tita.utils.EventObserver
import com.example.tita.utils.errorAnimationShow
import com.example.tita.utils.successAnimationShow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.regex.Pattern

@AndroidEntryPoint
class FindPasswordFinishFragment : Fragment() {

    private lateinit var binding : FragmentFindPasswordChangeBinding
    private val viewModel by activityViewModels<FindIdPasswordViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_find_password_change,container,false)

        with(viewModel){

            binding.nextBtn.setOnClickListener {
                lifecycleScope.launch{
                    passwordChangeAuthoritySend()
                } }

            lifecycleScope.launch {
                observerSuccess()
            }

            lifecycleScope.launch {
                observeFail()
            }

        }

        return binding.root
    }

    suspend fun passwordChangeAuthoritySend(){
        if(TextUtils.isEmpty(binding.passwordEdit.text) || TextUtils.isEmpty(binding.checkEdit.text)){
            binding.checkPasswordErrorText.errorAnimationShow(
                requireContext(),
                "빈칸없이 적어주세요.(비밀번호, 비밀번호 확인)")
        }

        else if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$",binding.checkEdit.text)){
                binding.passwordCheckErrorText.errorAnimationShow(requireContext(),"영어, 숫자, 특수문자만을 섞어 8~16자로 다시 입력해주세요.")
        }

        else if (binding.passwordEdit.text != binding.checkEdit.text){
            binding.checkPasswordErrorText.errorAnimationShow(
                requireContext(),
                "비밀번호와 비밀번호확인란이 서로 맞지않습니다.")
        }
        else{
            viewModel.putPasswordChange(binding.passwordEdit.text.toString(),binding.checkEdit.text.toString())
        }
    }

    private fun observerSuccess(){
        lifecycleScope.launch {
            viewModel.isSuccess.observe(viewLifecycleOwner, EventObserver{
                Log.d("TAG", "onViewCreated: success $it")
                binding.passwordCheckErrorText.successAnimationShow(requireContext(),it)

                with(viewModel){

                    lifecycleScope.launch {
                        viewModel.getPasswordChangeCode(binding.checkEdit.text.toString())
                    }
                }

            })
        }
    }

    private fun observeFail() {
        lifecycleScope.launch {

            viewModel.isFailure.observe(viewLifecycleOwner, EventObserver {
                Log.d("TAG", "onViewCreated: fall $it")
                binding.passwordCheckErrorText.errorAnimationShow(requireContext(), it)
            })
        }
    }
}
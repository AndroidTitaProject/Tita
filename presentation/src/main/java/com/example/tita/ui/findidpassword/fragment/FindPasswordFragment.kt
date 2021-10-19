package com.example.tita.ui.findidpassword.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.databinding.FragmentFindPasswordBinding
import com.example.tita.ui.findidpassword.fragment.viewmodel.FindIdPasswordViewModel
import com.example.tita.utils.EventObserver
import com.example.tita.utils.errorAnimationShow
import com.example.tita.utils.successAnimationShow
import kotlinx.coroutines.launch

class FindPasswordFragment : Fragment() {
    private lateinit var binding : FragmentFindPasswordBinding
    private val viewModel by activityViewModels<FindIdPasswordViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_find_password,container,false)

        with(viewModel){

            binding.okBtn.setOnClickListener {
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
        if(TextUtils.isEmpty(binding.CertificationEdit.text) || TextUtils.isEmpty(binding.checkPasswordId.text)){
            binding.errorCerPasswordText.errorAnimationShow(
                requireContext(),
                "빈칸없이 적어주세요.(아이디, 이메일)")
        }
        else{
            viewModel.passwordChangeAuthoritySend(binding.CertificationEdit.text.toString(),binding.checkPasswordId.text.toString())
        }
    }

    private fun observerSuccess(){
        lifecycleScope.launch {
            viewModel.isSuccess.observe(viewLifecycleOwner, EventObserver{
                Log.d("TAG", "onViewCreated: success $it")
                binding.errorEmailText.successAnimationShow(requireContext(),it)

            })
        }
    }

    private fun observeFail() {
        lifecycleScope.launch {

            viewModel.isFailure.observe(viewLifecycleOwner, EventObserver {
                Log.d("TAG", "onViewCreated: fall $it")
                binding.errorEmailText.errorAnimationShow(requireContext(), it)
            })
        }
    }

    private fun nextBtnOnClick() {
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_find_password_to_change_password)
        }
    }
}
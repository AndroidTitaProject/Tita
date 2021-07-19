package com.example.tita.ui.fragment.login


import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tita.R
import com.example.tita.Resource
import com.example.tita.VIewInterface
import com.example.tita.base.UtilityBase
import com.example.tita.databinding.FragmentLoginBinding
import com.example.tita.ui.activity.NavigationMainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LoginFragment : UtilityBase.BaseFragment<FragmentLoginBinding>(R.layout.fragment_login),
    VIewInterface {

    private  val  loginViewModel: LoginViewModel by viewModels()


    @InternalCoroutinesApi
    override fun FragmentLoginBinding.onCreateView() {



    }

    override fun FragmentLoginBinding.onViewCreated() {
        binding.login = loginViewModel
        binding.fragment = this@LoginFragment
    }


    @InternalCoroutinesApi
    private fun tryLogin(id: String, pwd: String) {
        if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(pwd)) {
            lifecycleScope.launch {
                loginViewModel.checkLogin(id, pwd)
                returnLoginValue()

            }
        } else {
            Toast.makeText(requireContext(), "빈칸을 입력해주세요.", Toast.LENGTH_SHORT).show()
        }

    }

    @InternalCoroutinesApi
    private fun returnLoginValue() {

        loginViewModel.postLogin.observe(this, Observer {

            when (it) {

                is Resource.Success -> {
                    startActivity(Intent(requireContext(), NavigationMainActivity::class.java))

                }
                is Resource.Loading -> {

                    Toast.makeText(requireContext(), "로딩중..", Toast.LENGTH_SHORT).show()

                }

                is Resource.Error -> {
                    val animation =
                        AnimationUtils.loadAnimation(
                            requireContext(),
                            R.anim.find_id_password_effect
                        )
                    binding.findPasswordText.startAnimation(animation)
                    binding.forgetIdBtn.startAnimation(animation)

                }
            }


        })
    }

    @InternalCoroutinesApi
    override fun onclcik(v: View) {
        when (v) {
            binding.nextButton -> {
                tryLogin(binding.idEdit.text.toString(), binding.passwordEdit.text.toString())


            }
            binding.forgetIdBtn ->
                findNavController().navigate(R.id.action_LoginFragment_to_findFragment)
            binding.signUpText -> {
                findNavController().navigate(R.id.action_LoginFragment_to_signUpTermsFragment)
            }

            binding.findPasswordText -> {
                findNavController().navigate(R.id.action_LoginFragment_to_findPasswordFragment)
            }


        }
    }


}
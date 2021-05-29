package com.example.tita.TunedCode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.tita.LoginActivity
import com.example.tita.R
import com.example.tita.databinding.ActivitySignUpBinding
import com.example.tita.databinding.ActivitySignUpMainPageBinding

class SignUpMainPage : AppCompatActivity() {

    private lateinit var bindingMainPage : ActivitySignUpMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMainPage = DataBindingUtil.setContentView(this,R.layout.activity_sign_up_main_page)

        bindingMainPage.signUpViewpager.adapter = SignUp_Adapter(this)

        //뒤에 로딩 2개 제한
        bindingMainPage.signUpViewpager.offscreenPageLimit = 2
    }
}
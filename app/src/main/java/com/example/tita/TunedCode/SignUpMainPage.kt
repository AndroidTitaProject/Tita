package com.example.tita.TunedCode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.example.tita.LoginActivity
import com.example.tita.R
<<<<<<< HEAD
import com.example.tita.databinding.ActivitySignUpBinding
=======
>>>>>>> [UPDATE] SignUpPage
import com.example.tita.databinding.ActivitySignUpMainPageBinding

class SignUpMainPage : AppCompatActivity() {

    private lateinit var bindingMainPage : ActivitySignUpMainPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMainPage = DataBindingUtil.setContentView(this,R.layout.activity_sign_up_main_page)

<<<<<<< HEAD
        bindingMainPage.signUpViewpager.adapter = SignUp_Adapter(this)
=======
        bindingMainPage.nextButton.setOnClickListener {
            bindingMainPage.signUpViewpager.setCurrentItem(getItem(+1), true) }

        bindingMainPage.signUpViewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        bindingMainPage.nextButton.setText("다음")
                    }
                    1 -> {
                        bindingMainPage.nextButton.setText("다음")
                    }
                    2 -> {
                        bindingMainPage.nextButton.setText("가입")
                        bindingMainPage.nextButton.setOnClickListener {
                            finish()
                            startActivity(Intent(this@SignUpMainPage,LoginActivity::class.java))
                        }
                    }
                }
            }
        })

        bindingMainPage.signUpViewpager.adapter = SignUp_Adapter(supportFragmentManager)
>>>>>>> [UPDATE] SignUpPage

        //뒤에 로딩 2개 제한
        bindingMainPage.signUpViewpager.offscreenPageLimit = 2
    }
<<<<<<< HEAD
=======

    private fun getItem(i: Int): Int {
        return bindingMainPage.signUpViewpager.getCurrentItem() + i
    }
>>>>>>> [UPDATE] SignUpPage
}
package com.example.tita.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tita.R
import com.example.tita.databinding.ActivityLoginBinding
import com.example.tita.ui.findidpassword.activity.FindIdActivity
import com.example.tita.ui.findidpassword.activity.FindPasswordActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.activity = this

    }

    fun findId(){
        startActivity(Intent(this,FindIdActivity::class.java))
    }
    fun findPassword(){
        startActivity(Intent(this,FindPasswordActivity::class.java))
    }
}
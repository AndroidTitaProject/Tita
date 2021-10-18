package com.example.tita.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tita.R
import com.example.tita.ui.findidpassword.activity.FindIdActivity
import com.example.tita.ui.findidpassword.activity.FindPasswordActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun findId(){
        startActivity(Intent(this,FindIdActivity::class.java))
    }
    fun findPassword(){
        startActivity(Intent(this,FindPasswordActivity::class.java))
    }
}
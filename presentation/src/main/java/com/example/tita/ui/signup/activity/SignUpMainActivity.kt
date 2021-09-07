package com.example.tita.ui.signup.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tita.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
    }


}
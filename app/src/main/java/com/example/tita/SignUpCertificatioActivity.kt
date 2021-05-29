package com.example.tita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tita.databinding.ActivityCertificatioBinding
import com.example.tita.databinding.ActivityLoginBinding

class SignUpCertificatioActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCertificatioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certificatio)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_certificatio)

        //binding..setOnClickListener {
        //    startActivity(Intent(this, SignUpIdPassward::class.java))
        //}
    }
}
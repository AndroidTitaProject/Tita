package com.example.tita.ui.activity

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tita.R

class SignUpMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setToolbarColor(R.color.main_color)
        supportActionBar!!.title = ""
    }
    private fun setToolbarColor(colorId: Int) {
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, colorId)))
    }

}
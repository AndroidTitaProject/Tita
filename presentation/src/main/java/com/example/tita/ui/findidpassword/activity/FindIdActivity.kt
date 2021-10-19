package com.example.tita.ui.findidpassword.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tita.R
import com.example.tita.base.UtilityBase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindIdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id)
    }

    override fun onBackPressed() {
        //super.onBackPressed();
    }
}
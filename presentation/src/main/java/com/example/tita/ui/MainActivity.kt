package com.example.tita.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tita.R
import com.example.tita.base.UtilityBase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
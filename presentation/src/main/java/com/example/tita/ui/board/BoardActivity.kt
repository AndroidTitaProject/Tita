package com.example.tita.ui.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tita.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
    }
}
package com.example.tita.util

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView


fun textAnimation(text: TextView, context: Context, animation: Int) {
    val animation = AnimationUtils.loadAnimation(context, animation)
    text.visibility = View.VISIBLE
    text.startAnimation(animation)
}
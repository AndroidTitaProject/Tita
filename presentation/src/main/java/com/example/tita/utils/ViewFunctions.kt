package com.example.tita.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tita.R


fun TextView.errorAnimationShow(context: Context, content: String) {
    text = content
    val animation = AnimationUtils.loadAnimation(context, R.anim.shake_error_text)
    visibility = View.VISIBLE
    setTextColor(ContextCompat.getColor(context, R.color.error_text))
    startAnimation(animation)
}

fun TextView.successAnimationShow(context: Context, content: String) {
    text = content
    val animation = AnimationUtils.loadAnimation(context, R.anim.shake_error_text)
    setTextColor(ContextCompat.getColor(context, R.color.black))
    visibility = View.VISIBLE
    startAnimation(animation)
}

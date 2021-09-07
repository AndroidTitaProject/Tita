package com.example.tita.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.tita.R


fun TextView.errorAnimationShow(context: Context, content: String) {
    text = content
    val animation = AnimationUtils.loadAnimation(context, R.anim.shake_error_text)
    visibility = View.VISIBLE
    startAnimation(animation)
}

fun TextView.successAnimationShow(context: Context, content: String) {
    text = content
    val animation = AnimationUtils.loadAnimation(context, R.anim.shake_error_text)
    visibility = View.VISIBLE
    startAnimation(animation)
}

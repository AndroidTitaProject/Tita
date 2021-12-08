package com.example.data.entity.signup.response

data class NickNameOverlapResponse(
    val success: Boolean,
    val code: Int,
    val msg: String,
    val data: Boolean
)
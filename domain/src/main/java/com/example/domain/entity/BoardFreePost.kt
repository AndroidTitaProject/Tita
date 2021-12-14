package com.example.domain.entity

import com.google.gson.annotations.SerializedName

data class BoardFreePost (
@SerializedName("success")
val success: Boolean,
@SerializedName("code")
val code: Int,
@SerializedName("msg")
val msg: String
)
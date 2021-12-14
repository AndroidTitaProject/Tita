package com.example.data.entity.board.response

import com.google.gson.annotations.SerializedName

data class BoardFreeResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("code")
    val code: Int,
    @SerializedName("msg")
    val msg: String
)
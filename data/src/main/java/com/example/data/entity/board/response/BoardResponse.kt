package com.example.data.entity.board.response


import com.google.gson.annotations.SerializedName

data class BoardResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<BoardData>,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("success")
    val success: Boolean
)
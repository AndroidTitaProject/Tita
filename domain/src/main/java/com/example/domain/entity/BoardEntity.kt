package com.example.domain.entity


import com.google.gson.annotations.SerializedName

data class BoardEntity(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: List<BoardData>,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("success")
    val success: Boolean
)
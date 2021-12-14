package com.example.data.entity.board.request


import com.google.gson.annotations.SerializedName

data class BoardFreePostRequest(
    @SerializedName("content")
    val content: String,
    @SerializedName("postName")
    val postName: String
)
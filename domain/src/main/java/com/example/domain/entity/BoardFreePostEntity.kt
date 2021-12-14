package com.example.domain.entity

import com.google.gson.annotations.SerializedName

data class BoardFreePostEntity (
    @SerializedName("content")
    val content: String,
    @SerializedName("postName")
    val postName: String
)
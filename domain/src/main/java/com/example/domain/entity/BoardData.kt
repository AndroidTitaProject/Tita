package com.example.domain.entity

import com.google.gson.annotations.SerializedName

data class BoardData(
    @SerializedName("Content") 
    val content: String,
    @SerializedName("PostName")
    val postName: String
)
package com.example.data.entity.school.search


import com.google.gson.annotations.SerializedName

data class RESULT(
    @SerializedName("CODE")
    val cODE: String?,
    @SerializedName("MESSAGE")
    val mESSAGE: String?
)
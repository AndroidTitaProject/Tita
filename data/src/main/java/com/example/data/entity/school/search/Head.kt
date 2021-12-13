package com.example.data.entity.school.search


import com.google.gson.annotations.SerializedName

data class Head(
    @SerializedName("list_total_count")
    val listTotalCount: Int?,
    @SerializedName("RESULT")
    val rESULT: RESULT?
)
package com.example.data.entity.school.search


import com.google.gson.annotations.SerializedName

data class SearchSchoolResponse(
    @SerializedName("schoolInfo")
    val schoolInfo: List<SchoolInfo>
)
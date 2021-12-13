package com.example.data.entity.school.search


import com.google.gson.annotations.SerializedName

data class SchoolInfo(
    @SerializedName("head")
    val head: List<Head>?,
    @SerializedName("row")
    val row: List<Row>?
) {

}
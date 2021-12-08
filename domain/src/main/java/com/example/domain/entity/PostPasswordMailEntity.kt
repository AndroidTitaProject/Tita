package com.example.domain.entity

data class PostPasswordMailEntity(
    val success: Boolean,
    val code: Int,
    val msg: String
)
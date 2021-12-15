package com.example.domain.entity.find

data class PutChangePasswordEntity(
    val success: Boolean,
    val code: Int,
    val msg: String
 )
package com.example.domain.entity

data class PutChangePasswordEntity(
    val success: Boolean,
    val code: Int,
    val msg: String
 )
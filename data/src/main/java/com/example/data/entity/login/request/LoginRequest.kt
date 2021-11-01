package com.example.data.entity.login.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(@SerializedName("username") val id : String, val password: String)

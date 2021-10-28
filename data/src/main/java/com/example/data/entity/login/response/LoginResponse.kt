package com.example.data.entity.login.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val loginData: LoginData?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("success")
    val success: Boolean
)

data class LoginData(
    @SerializedName("acessToken")
    val accessToken: String?,
    @SerializedName("refreshToken")
    val refreshToken: String?,
    @SerializedName("username")
    val username: String?
)
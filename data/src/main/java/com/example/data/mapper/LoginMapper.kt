package com.example.data.mapper

import com.example.data.entity.login.response.LoginData
import com.example.data.entity.login.response.LoginResponse
import com.example.domain.entity.Data
import com.example.domain.entity.LoginEntity

fun LoginResponse.toDomain(): LoginEntity {
    return LoginEntity(
        this.code,
        this.loginData?.toDomain(),
        this.msg,
        this.success
    )
}

fun LoginData.toDomain(): Data {
    return Data(
        this.accessToken,
        this.refreshToken,
        this.username
    )
}
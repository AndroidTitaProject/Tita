package com.example.data.repository.login.datasource

import com.example.data.entity.login.response.LoginResponse
import com.example.data.entity.login.request.LoginRequest
import io.reactivex.rxjava3.core.Single

interface LoginDataSource {
    suspend fun login(body : LoginRequest) : Single<LoginResponse>
}
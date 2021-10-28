package com.example.data.network.service

import com.example.data.entity.login.response.LoginResponse
import com.example.data.entity.login.request.LoginRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("tita/login")
    fun login(
        @Body body : LoginRequest
    ): Single<LoginResponse>
}
package com.example.tita.data.network

import com.example.tita.data.model.Signupdata
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiInterface {

    @POST("user/signup")
    fun signup(): Response<Signupdata>

    @POST("user/login")
    fun postLogin(
        @Body id: String,
        @Body pwd: String
    ): Response<Signupdata>

    //@GET("/tita/logout")
}
package com.example.tita.data

import retrofit2.Call
import retrofit2.http.POST

interface LoginApiInterface {

    @POST("/signup")
    fun signup() : Call<Signupdata>

    @POST("/login")
    fun login() : Call<Signupdata>

    //@GET("/tita/logout")
}
package com.example.tita.data.network

import com.example.tita.data.model.BoardData
import com.example.tita.data.model.Signupdata
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiInterface {

    //회원가입 요청
    @POST("user/signup")
    fun signup(): Response<Signupdata>

    //로그인 요청
    @POST("user/login")
    fun postLogin(
        @Body id: String,
        @Body pwd: String
    ): Response<Signupdata>



    //@GET("/tita/logout")
}
package com.example.tita.data.network

import com.example.tita.data.network.dto.*
import retrofit2.Response
import retrofit2.http.*


interface LoginApiInterface {

    @POST("user/signup")
    fun signup(): Response<SignUpdData>


    //Field 형식을 사용할 때는 Form이 Encoding되어야 합니다. 따라서 FormUrlEncoded라는 Annotation을 해주어야 합니다.
    @FormUrlEncoded
    @POST("user/login")
    suspend fun postLogin(
        @Field("id") id: String,
        @Field("pwd") pwd: String
    ): Response<LoginData>

    @FormUrlEncoded
    @POST("user/verify")
    suspend fun postMail(
        @Field("mail") mail: String
    ): Response<MailData>


    @POST("user/verify/{key}")
    fun getPasswordMail(
        @Path("key") key: String
    ): Response<MailCertifiedData>


}
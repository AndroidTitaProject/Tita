package com.example.data.network.service

import com.example.data.entity.GetMailDto
import com.example.data.entity.SignUpDto
import com.example.data.util.Response
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface UserApi {
    @FormUrlEncoded
    @GET("signup")
    suspend fun postSignUp(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("school") school: String,
        @Field("email") email: String,

        ): Single<retrofit2.Response<Response<SignUpDto>>>


    @GET("verify/key")
    suspend fun getMail(
        @Query("mail") mail: String
    ): Single<retrofit2.Response<Response<GetMailDto>>>
}

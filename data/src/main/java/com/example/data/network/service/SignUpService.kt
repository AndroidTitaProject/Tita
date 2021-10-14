package com.example.data.network.service

import com.example.data.base.BaseResponse
import com.example.data.entity.GetMailResponse
import com.example.data.entity.signup.request.SignUpRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface SignUpService {
    @FormUrlEncoded
    @GET("signup")
    suspend fun postSignUp(
        @Body request: SignUpRequest
    ): Single<BaseResponse>


    @GET("verify/key")
    suspend fun getMail(
        @Query("mail") mail: String
    ): Single<GetMailResponse>
}

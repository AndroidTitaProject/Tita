package com.example.data.network.service

import com.example.data.base.BaseResponse
import com.example.data.entity.signup.response.GetMailResponse
import com.example.data.entity.signup.response.IdCheckResponse
import com.example.data.entity.signup.response.NickNameOverlapResponse
import com.example.data.entity.signup.request.GetMailRequest
import com.example.data.entity.signup.request.SignUpRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SignUpService {
    @POST("tita/signup")
     fun postSignUp(
        @Body request: SignUpRequest
    ): Single<BaseResponse>


    @POST("tita/verify")
     fun getMail(
        @Body request: GetMailRequest
    ): Single<GetMailResponse>

    @GET("tita/username/{username}/exists")
    fun getIdCheck(
        @Path("username") userName: String
    ): Single<IdCheckResponse>

    @GET("tita/username/{name}/exists")
     fun getNameOverlap(
        @Path("name") name: String
    ) : Single<NickNameOverlapResponse>


}

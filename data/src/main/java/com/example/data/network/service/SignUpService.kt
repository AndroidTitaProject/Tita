package com.example.data.network.service

import com.example.data.base.BaseResponse
import com.example.data.entity.signup.response.GetMailResponse
import com.example.data.entity.signup.response.IdCheckResponse
import com.example.data.entity.signup.response.NickNameOverlapResponse
import com.example.data.entity.signup.request.GetMailRequest
import com.example.data.entity.signup.request.SignUpRequest
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SignUpService {
    @POST("tita/user/signup")
     fun postSignUp(
        @Body request: SignUpRequest
    ): Single<BaseResponse>


    @POST("tita/verify")
     fun getMail(
        @Body request: GetMailRequest
    ): Single<GetMailResponse>

     // 아이디 중복확인
    @GET("tita/user/username/{username}/exists")
    fun getIdCheck(
        @Path("username") userName: String
    ): Single<IdCheckResponse>

    // 닉네임 중복확인
    @GET("tita/user/name/{name}/exists")
     fun getNameOverlap(
        @Path("name") name: String
    ) : Single<NickNameOverlapResponse>

    @GET("tita/username/{name}/exists")
    fun getNameOverlaps(
        @Path("name") name: String
    ) : Observable<NickNameOverlapResponse>

}

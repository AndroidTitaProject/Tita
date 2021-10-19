package com.example.data.network.service

import com.example.data.base.BaseResponse
import com.example.data.entity.findpassword.request.GetMailCodeRequest
import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.entity.findpassword.response.PasswordMailCodeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface FindIdPasswordService {

    //비밀번호 찾기 이메일 인증

    @POST("tita/password")
     fun postMailAndUserName(
        @Body request : PasswordMailRequest
    ): Single<BaseResponse>

    @GET("tita/password/key")
     fun getMailCode(
        @Path("code") code : String
    ) : Single<PasswordMailCodeResponse>
}

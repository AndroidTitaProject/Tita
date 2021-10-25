package com.example.data.network.service

import com.example.data.base.SignUpBaseResponse
import com.example.data.entity.findpassword.request.PasswordChangeRequest
import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.entity.findpassword.response.PasswordChangeResponse
import com.example.data.entity.findpassword.response.PasswordMailCodeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface FindIdPasswordService {

    //비밀번호 찾기 이메일 인증

    @POST("tita/password")
     fun postMailAndUserName(
        @Body request : PasswordMailRequest
    ): Single<SignUpBaseResponse>

    @GET("tita/password/key")
     fun getMailCode(
        @Path("code") code : String
    ) : Single<PasswordMailCodeResponse>

     @PUT("/tita/password")
     fun putPasswordChange(
         @Body request : PasswordChangeRequest
     ) : Single<PasswordChangeResponse>
}

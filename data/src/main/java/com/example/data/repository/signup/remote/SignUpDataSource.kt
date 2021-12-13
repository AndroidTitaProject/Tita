package com.example.data.repository.signup.remote

import com.example.data.base.BaseResponse
import com.example.data.base.SignUpBaseResponse
import com.example.data.entity.signup.response.GetMailResponse
import com.example.data.entity.signup.response.IdCheckResponse
import com.example.data.entity.signup.response.NickNameOverlapResponse
import com.example.data.entity.signup.request.GetMailRequest
import com.example.data.entity.signup.request.SignUpRequest
import io.reactivex.rxjava3.core.Single

interface SignUpDataSource  {
    suspend  fun postSignUp(request:SignUpRequest) : Single<BaseResponse>
    suspend  fun postMail(mail :GetMailRequest) : Single<GetMailResponse>
    suspend  fun getIdCheck(userName :String) : Single<IdCheckResponse>
    suspend  fun getNickNameOverlap(name :String) : Single<NickNameOverlapResponse>
}
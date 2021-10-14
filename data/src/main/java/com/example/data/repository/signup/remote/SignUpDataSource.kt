package com.example.data.repository.signup.remote

import com.example.data.base.BaseResponse
import com.example.data.entity.GetMailResponse
import com.example.data.entity.signup.request.SignUpRequest
import io.reactivex.rxjava3.core.Single

interface SignUpDataSource  {
    suspend  fun postSignUp(request:SignUpRequest) : Single<BaseResponse>
    suspend  fun getMail(mail :String) : Single<GetMailResponse>
}
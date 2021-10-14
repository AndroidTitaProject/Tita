package com.example.data.repository.signup.remote

import com.example.data.base.BaseDataSource
import com.example.data.base.BaseResponse
import com.example.data.entity.GetMailResponse
import com.example.data.entity.signup.request.SignUpRequest
import com.example.data.network.service.SignUpService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SignUpDataSourceImpl @Inject constructor(
    override val service: SignUpService

) : BaseDataSource<SignUpService>(), SignUpDataSource {


    override suspend fun postSignUp(request: SignUpRequest): Single<BaseResponse> =
        service.postSignUp(request)

    override suspend fun getMail(mail: String): Single<GetMailResponse> =
        service.getMail(mail)
}
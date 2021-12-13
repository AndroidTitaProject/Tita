package com.example.data.repository.signup.remote

import com.example.data.base.BaseDataSource
import com.example.data.base.BaseResponse
import com.example.data.base.SignUpBaseResponse
import com.example.data.entity.signup.response.GetMailResponse
import com.example.data.entity.signup.response.IdCheckResponse
import com.example.data.entity.signup.response.NickNameOverlapResponse
import com.example.data.entity.signup.request.GetMailRequest
import com.example.data.entity.signup.request.SignUpRequest
import com.example.data.network.service.SignUpService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SignUpDataSourceImpl @Inject constructor(
    override val service: SignUpService

) : BaseDataSource<SignUpService>(), SignUpDataSource {


    override suspend fun postSignUp(request: SignUpRequest): Single<BaseResponse> =
        service.postSignUp(request)

    override suspend fun postMail(mail: GetMailRequest): Single<GetMailResponse> =
        service.getMail(mail)

    override suspend fun getIdCheck(userName: String): Single<IdCheckResponse> =
        service.getIdCheck(userName)

    override suspend fun getNickNameOverlap(name: String): Single<NickNameOverlapResponse> =
        service.getNameOverlap(name)

}
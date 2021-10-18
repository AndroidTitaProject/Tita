package com.example.data.repository.signup.datasource

import com.example.data.base.BaseDataSource
import com.example.data.base.BaseResponse
import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.entity.findpassword.response.PasswordMailResponse
import com.example.data.network.service.FindIdPasswordService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FindPasswordDataSourceImpl @Inject constructor(
    override val service: FindIdPasswordService

) : BaseDataSource<FindIdPasswordService>(),
    FindPasswordDataSource{

//    override suspend fun postSignUp(request: SignUpRequest): Single<BaseResponse> =
//        service.postSignUp(request)
//
//    override suspend fun getMail(mail: String): Single<GetMailResponse> =
//        service.getMail(mail)

    override suspend fun postPassword(request: PasswordMailRequest): Single<BaseResponse>
            = service.postMailAndUserName(request)

    override suspend fun getCode(mail: String): Single<PasswordMailResponse> {
        TODO()
    }
}
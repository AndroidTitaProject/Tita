package com.example.data.repository.find.datasource

import com.example.data.base.BaseDataSource
import com.example.data.base.BaseResponse
import com.example.data.entity.find.request.PasswordChangeRequest
import com.example.data.entity.find.request.PasswordMailRequest
import com.example.data.entity.find.response.PasswordChangeResponse
import com.example.data.entity.find.response.PasswordMailCodeResponse
import com.example.data.network.service.FindService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FindDataSourceImpl @Inject constructor(
    override val service: FindService

) : BaseDataSource<FindService>(),
    FindDataSource{

    override suspend fun postPassword(request: PasswordMailRequest): Single<BaseResponse>
    {
        return service.postMailAndUserName(request)
    }


    override suspend fun getCode(code : String): Single<PasswordMailCodeResponse>
            = service.getMailCode(code)

    override suspend fun putChangePassword(request: PasswordChangeRequest): Single<PasswordChangeResponse>
            = service.putPasswordChange(request)
}
package com.example.data.repository.login.datasource

import com.example.data.base.BaseDataSource
import com.example.data.entity.login.response.LoginResponse
import com.example.data.entity.login.request.LoginRequest
import com.example.data.network.service.LoginService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(override val service: LoginService) :
    BaseDataSource<LoginService>(), LoginDataSource {
    override suspend fun login(body: LoginRequest): Single<LoginResponse> =
        service.login(body)


}
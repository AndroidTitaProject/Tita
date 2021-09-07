package com.example.data.repository

import com.example.data.datasource.RemoteSignUpDataSource
import com.example.domain.entity.request.SignUpRequest
import com.example.domain.entity.response.GetMailEntity
import com.example.domain.entity.response.SignUpEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataSource: RemoteSignUpDataSource

) : AuthRepository{
    override suspend fun postSignUp(request: SignUpRequest): Single<SignUpEntity> {
       return dataSource.postSignUp(request)
    }

    override suspend fun getMail(mail: String): Single<GetMailEntity> {
        return dataSource.getMail(mail)
    }


}
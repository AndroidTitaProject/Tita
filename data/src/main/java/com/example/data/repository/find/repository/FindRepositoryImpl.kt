package com.example.data.repository.find.repository

import com.example.data.entity.find.request.PasswordChangeRequest
import com.example.data.entity.find.request.PasswordMailRequest
import com.example.data.mapper.toDomain
import com.example.data.mapper.toFindDomain
import com.example.data.repository.find.datasource.FindDataSource
import com.example.domain.entity.find.GetPasswordCodeEntity
import com.example.domain.entity.find.PostPasswordMailEntity
import com.example.domain.entity.find.PutChangePasswordEntity
import com.example.domain.repository.FindRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class FindRepositoryImpl @Inject constructor(
    private val dataSourceImpl: FindDataSource

) : FindRepository {

    //원래 다른 계층을 참조 못해 저런식으로 매핑해주는것!

    override suspend fun postPasswordEmail(
        email: String,
        username: String
    ): Single<PostPasswordMailEntity> {
        return dataSourceImpl.postPassword(PasswordMailRequest(email, username))
            .map { it.toFindDomain() }
    }

    override suspend fun getPasswordCode(code: String): Single<GetPasswordCodeEntity> {
        return dataSourceImpl.getCode(code).map { it.toDomain() }
    }

    override suspend fun putChangePassword(
        username: String,
        password: String
    ): Single<PutChangePasswordEntity> {
        return dataSourceImpl.putChangePassword(PasswordChangeRequest(username, password))
            .map { it.toDomain() }
    }


}
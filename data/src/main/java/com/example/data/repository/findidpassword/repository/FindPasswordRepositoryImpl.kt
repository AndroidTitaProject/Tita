package com.example.data.repository.findidpassword.repository

import android.util.Log
import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.mapper.toDomain
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSource
import com.example.domain.entity.GetPasswordCodeEntity
import com.example.domain.entity.PostPasswordMailEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class FindPasswordRepositoryImpl @Inject constructor(
    private val dataSourceImpl: FindPasswordDataSource

) : AuthRepository {

    //원래 다른 계층을 참조 못해 저런식으로 매핑해주는것!

    override suspend fun postPasswordEmail(
        email: String,
        nickname: String
    ): Single<PostPasswordMailEntity> {
        return dataSourceImpl.postPassword(PasswordMailRequest(email,nickname)).map { it.toDomain() }
    }

    override suspend fun getPasswordCode(code: String): Single<GetPasswordCodeEntity> {
        return dataSourceImpl.getCode(code).map { it.toDomain() }
    }


}
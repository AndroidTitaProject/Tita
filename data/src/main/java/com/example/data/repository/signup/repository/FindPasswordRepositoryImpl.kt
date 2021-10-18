package com.example.data.repository.signup.repository

import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.mapper.toDomain
import com.example.data.repository.signup.datasource.FindPasswordDataSource
import com.example.domain.entity.GetPasswordCodeEntity
import com.example.domain.entity.PostPasswordMailEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class FindPasswordRepositoryImpl @Inject constructor(
    private val dataSourceImpl: FindPasswordDataSource

) : AuthRepository {

//    override suspend fun postSignUp(
//        username: String,
//        password: String,
//        name: String,
//        school: String,
//        email: String
//    ): Single<SignUpEntity> {
//        return dataSourceImpl.postSignUp(SignUpRequest(username, password, name, school, email))
//            .map { it.toDomain() }
//    }
////
//    override suspend fun getMail(mail: String): Single<GetMailEntity> {
//        return dataSourceImpl.getMail(mail).map { it.toDomain() }
//    }

    override suspend fun postPasswordEmail(
        email: String,
        nickname: String
    ): Single<PostPasswordMailEntity> {
        return dataSourceImpl.postPassword(PasswordMailRequest(email,nickname)).map { it.toDomain() }
    }

    override suspend fun getPasswordCode(code: String): Single<GetPasswordCodeEntity> {
        TODO("Not yet implemented")
    }


}
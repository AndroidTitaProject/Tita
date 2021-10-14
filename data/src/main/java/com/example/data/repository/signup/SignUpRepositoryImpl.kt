package com.example.data.repository.signup

import com.example.data.entity.signup.request.SignUpRequest
import com.example.data.mapper.toDomain
import com.example.data.repository.signup.remote.SignUpDataSourceImpl
import com.example.domain.entity.GetMailEntity
import com.example.domain.entity.SignUpEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


// dataSourceImpl -> repository
class SignUpRepositoryImpl @Inject constructor(
    private val dataSourceImpl: SignUpDataSourceImpl

) : AuthRepository {

    override suspend fun postSignUp(
        username: String,
        password: String,
        name: String,
        school: String,
        email: String
    ): Single<SignUpEntity> {
        return dataSourceImpl.postSignUp(SignUpRequest(username, password, name, school, email))
            .map { it.toDomain() }
    }

    override suspend fun getMail(mail: String): Single<GetMailEntity> {
        return dataSourceImpl.getMail(mail).map { it.toDomain() }
    }


}
package com.example.data.repository.signup

import com.example.data.entity.signup.request.GetMailRequest
import com.example.data.entity.signup.request.SignUpRequest
import com.example.data.mapper.toDomain
import com.example.data.repository.signup.remote.SignUpDataSourceImpl
import com.example.domain.entity.signup.GetMailEntity
import com.example.domain.entity.signup.IdCheckEntity
import com.example.domain.entity.signup.NickNameEntity
import com.example.domain.entity.signup.SignUpEntity
import com.example.domain.repository.SignUpRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


// dataSourceImpl -> repository
class SignUpRepositoryImpl @Inject constructor(
    private val dataSourceImpl: SignUpDataSourceImpl

) : SignUpRepository {

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
        return dataSourceImpl.postMail(GetMailRequest(mail)).map { it.toDomain() }
    }

    override suspend fun getIdCheck(userName: String): Single<IdCheckEntity> =
        dataSourceImpl.getIdCheck(userName).map { it.toDomain() }

    override suspend fun getNickName(name: String): Single<NickNameEntity> =
        dataSourceImpl.getNickNameOverlap(name).map { it.toDomain() }


}
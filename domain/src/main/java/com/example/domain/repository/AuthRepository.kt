package com.example.domain.repository

import com.example.domain.entity.*
import io.reactivex.rxjava3.core.Single

interface AuthRepository {
    suspend fun postSignUp(
        username: String,
        password: String,
        name: String,
        school: String,
        email: String
    ): Single<SignUpEntity>

    suspend fun getMail(mail: String): Single<GetMailEntity>
    suspend fun getIdCheck(userName : String) : Single<IdCheckEntity>
    suspend fun getNickName(name : String) : Single<NickNameEntity>
}
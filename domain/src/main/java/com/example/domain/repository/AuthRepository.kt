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

    suspend fun postPasswordEmail(email : String, username : String): Single<PostPasswordMailEntity>

    suspend fun getPasswordCode(code : String): Single<GetPasswordCodeEntity>

    suspend fun putChangePassword(username : String,password : String): Single<PutChangePasswordEntity>

    suspend fun getMail(mail: String): Single<GetMailEntity>
    suspend fun getIdCheck(userName : String) : Single<IdCheckEntity>
    suspend fun getNickName(name : String) : Single<NickNameEntity>
}
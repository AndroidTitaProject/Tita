package com.example.domain.repository

import com.example.domain.entity.GetMailEntity
import com.example.domain.entity.SignUpEntity
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
}
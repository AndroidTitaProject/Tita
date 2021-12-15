package com.example.domain.repository

import com.example.domain.entity.find.GetPasswordCodeEntity
import com.example.domain.entity.find.PostPasswordMailEntity
import com.example.domain.entity.find.PutChangePasswordEntity
import io.reactivex.rxjava3.core.Single

interface FindRepository {
    suspend fun postPasswordEmail(email : String, username : String): Single<PostPasswordMailEntity>

    suspend fun getPasswordCode(code : String): Single<GetPasswordCodeEntity>

    suspend fun putChangePassword(username : String,password : String): Single<PutChangePasswordEntity>
}
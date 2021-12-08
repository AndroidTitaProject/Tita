package com.example.domain.repository

import com.example.domain.entity.GetMailEntity
import com.example.domain.entity.GetPasswordCodeEntity
import com.example.domain.entity.PostPasswordMailEntity
import com.example.domain.entity.PutChangePasswordEntity
import io.reactivex.rxjava3.core.Single

interface FindIdAndPasswordRepository {

    suspend fun postPasswordEmail(email : String, username : String): Single<PostPasswordMailEntity>

    suspend fun getPasswordCode(code : String): Single<GetPasswordCodeEntity>

    suspend fun putChangePassword(username : String,password : String): Single<PutChangePasswordEntity>
}
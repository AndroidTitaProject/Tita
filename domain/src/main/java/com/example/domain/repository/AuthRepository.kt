package com.example.domain.repository

import com.example.domain.entity.GetPasswordCodeEntity
import com.example.domain.entity.PostPasswordMailEntity
import io.reactivex.rxjava3.core.Single

interface AuthRepository {
    suspend fun postPasswordEmail(email : String, username : String): Single<PostPasswordMailEntity>

    suspend fun getPasswordCode(code : String): Single<GetPasswordCodeEntity>
}
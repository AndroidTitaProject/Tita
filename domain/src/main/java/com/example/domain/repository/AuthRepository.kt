package com.example.domain.repository

import com.example.domain.entity.request.SignUpRequest
import com.example.domain.entity.response.GetMailEntity
import com.example.domain.entity.response.SignUpEntity
import io.reactivex.rxjava3.core.Single

interface AuthRepository {
    suspend fun postSignUp(request: SignUpRequest): Single<SignUpEntity>
    suspend fun getMail(mail: String): Single<GetMailEntity>

}
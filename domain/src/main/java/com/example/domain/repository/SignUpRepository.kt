package com.example.domain.repository

import com.example.domain.entity.signup.GetMailEntity
import com.example.domain.entity.signup.IdCheckEntity
import com.example.domain.entity.signup.NickNameEntity
import com.example.domain.entity.signup.SignUpEntity
import io.reactivex.rxjava3.core.Single

interface SignUpRepository {
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
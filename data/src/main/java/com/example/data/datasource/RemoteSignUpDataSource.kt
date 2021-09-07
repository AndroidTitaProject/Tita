package com.example.data.datasource

import com.example.data.base.BaseDataSource
import com.example.data.mapper.toEntity
import com.example.data.network.remote.AuthRemote
import com.example.domain.entity.request.SignUpRequest
import com.example.domain.entity.response.GetMailEntity
import com.example.domain.entity.response.SignUpEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RemoteSignUpDataSource @Inject constructor(
    override val remote: AuthRemote
) : BaseDataSource<AuthRemote>() {

    suspend fun postSignUp(request: SignUpRequest): Single<SignUpEntity> {
        return remote.postSignUp(request).map { it.toEntity() }
    }

    suspend fun getMail(mail: String): Single<GetMailEntity> {
        return remote.getEmail(mail).map { it.toEntity() }
    }
}
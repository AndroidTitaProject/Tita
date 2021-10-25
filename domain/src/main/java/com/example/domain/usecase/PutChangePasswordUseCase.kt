package com.example.domain.usecase

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.PostPasswordMailEntity
import com.example.domain.entity.PutChangePasswordEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PutChangePasswordUseCase @Inject constructor(private val repository: AuthRepository) :
    ParamsUseCase<PutChangePasswordUseCase.Params, Single<PutChangePasswordEntity>>() {

    data class Params(
        val username: String,
        val password: String
    )

    override suspend fun buildUseCaseObservable(params: Params): Single<PutChangePasswordEntity> {
        return repository.putChangePassword(
            username = params.username,
            password = params.password
        )
    }

}
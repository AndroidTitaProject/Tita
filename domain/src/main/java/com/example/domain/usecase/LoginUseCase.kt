package com.example.domain.usecase

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.LoginEntity
import com.example.domain.repository.LoginRepository
import com.example.domain.usecase.LoginUseCase.Params
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) :
    ParamsUseCase<Params, Single<LoginEntity>>() {


    override suspend fun buildUseCaseObservable(params: Params): Single<LoginEntity> =
        repository.login(params.id, password = params.password)

    data class Params(
        val id: String,
        val password: String
    )
}
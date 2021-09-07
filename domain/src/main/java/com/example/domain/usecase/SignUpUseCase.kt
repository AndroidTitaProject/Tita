package com.example.domain.usecase

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.request.SignUpRequest
import com.example.domain.entity.response.SignUpEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository:AuthRepository):
    ParamsUseCase<SignUpUseCase.Params,Single<SignUpEntity>>() {

    override suspend fun buildUseCaseObservable(params: Params): Single<SignUpEntity> {
        return repository.postSignUp(params.signUpRequest)
    }

    data class Params(
        val signUpRequest: SignUpRequest
    )



}
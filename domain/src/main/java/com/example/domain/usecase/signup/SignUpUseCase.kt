package com.example.domain.usecase.signup

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.SignUpEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository: AuthRepository) :
    ParamsUseCase<SignUpUseCase.Params, Single<SignUpEntity>>() {

    override suspend fun buildUseCaseObservable(params: Params): Single<SignUpEntity> {
        return repository.postSignUp(
            username = params.username,
            password = params.password,
            name = params.name,
            school = params.school,
            email = params.email
        )
    }

    data class Params(
        val username: String,
        val password: String,
        val name: String,
        val school: String,
        val email: String
    )


}
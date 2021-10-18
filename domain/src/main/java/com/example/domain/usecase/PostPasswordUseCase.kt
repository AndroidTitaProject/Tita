package com.example.domain.usecase

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.PostPasswordMailEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostPasswordUseCase @Inject constructor(private val repository: AuthRepository) :
    ParamsUseCase<PostPasswordUseCase.Params, Single<PostPasswordMailEntity>>() {

    override suspend fun buildUseCaseObservable(params: Params): Single<PostPasswordMailEntity> {
        return repository.postPasswordEmail(
            username = params.username,
            email = params.email
        )
    }

    data class Params(
        val username: String,
        val email: String
    )


}
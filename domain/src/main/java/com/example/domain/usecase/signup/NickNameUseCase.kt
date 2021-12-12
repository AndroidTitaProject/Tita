package com.example.domain.usecase.signup

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.NickNameEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NickNameUseCase @Inject constructor(private val repository: AuthRepository) :
    ParamsUseCase<NickNameUseCase.Params, Single<NickNameEntity>>() {


    data class Params(
        val name: String
    )



    override suspend fun buildUseCaseObservable(params: Params): Single<NickNameEntity> =
        repository.getNickName(params.name)
}
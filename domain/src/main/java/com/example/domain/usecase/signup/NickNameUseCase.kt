package com.example.domain.usecase.signup

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.signup.NickNameEntity
import com.example.domain.repository.SignUpRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class NickNameUseCase @Inject constructor(private val repository: SignUpRepository) :
    ParamsUseCase<NickNameUseCase.Params, Single<NickNameEntity>>() {


    data class Params(
        val name: String
    )



    override suspend fun buildUseCaseObservable(params: Params): Single<NickNameEntity> =
        repository.getNickName(params.name)
}
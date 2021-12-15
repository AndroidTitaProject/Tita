package com.example.domain.usecase.find

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.find.GetPasswordCodeEntity
import com.example.domain.repository.FindRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

//ViewModel 에서 사용

class GetPasswordCodeUseCase @Inject constructor(private val repository: FindRepository):
    ParamsUseCase<GetPasswordCodeUseCase.Params, Single<GetPasswordCodeEntity>>() {


    override suspend fun buildUseCaseObservable(params: Params): Single<GetPasswordCodeEntity> {
        return repository.getPasswordCode(params.code)
    }
    data class Params(
        val code : String
    )

}
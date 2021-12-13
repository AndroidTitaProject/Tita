package com.example.domain.usecase.signup

import android.util.Log
import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.IdCheckEntity
import com.example.domain.repository.AuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class  IdCheckUseCase @Inject constructor(private val repository: AuthRepository) :
    ParamsUseCase<IdCheckUseCase.Params, Single<IdCheckEntity>>()  {


    data class Params(
        val userName:String
    )

    override suspend fun buildUseCaseObservable(params: Params): Single<IdCheckEntity> {
        Log.d("TAG", "buildUseCaseObservable: ")
        return repository.getIdCheck(params.userName)
    }

}
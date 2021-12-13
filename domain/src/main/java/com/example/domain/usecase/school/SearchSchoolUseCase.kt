package com.example.domain.usecase.school

import android.util.Log
import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.IdCheckEntity
import com.example.domain.entity.school.SchoolInfoEntity
import com.example.domain.entity.school.SchoolResponseEntity
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.SchoolRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class  SearchSchoolUseCase @Inject constructor(private val repository: SchoolRepository) :
    ParamsUseCase<SearchSchoolUseCase.Params, Single<SchoolResponseEntity>>()  {


    data class Params(
        val schoolName:String,
        val type:String,
        val index:String,
        val size:String,
        val key:String,

    )

    override suspend fun buildUseCaseObservable(params: Params): Single<SchoolResponseEntity> {
        Log.d("TAG", "buildUseCaseObservable: ")
        return repository.searchSchool(params.schoolName,params.type,params.index,params.size,params.key)
    }

}
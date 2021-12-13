package com.example.data.repository.school

import com.example.data.mapper.toDomain
import com.example.data.repository.school.remote.SchoolDataSourceImpl
import com.example.domain.entity.school.SchoolResponseEntity
import com.example.domain.repository.SchoolRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SchoolSearchRepositoryImpl @Inject constructor(
    private val dataSourceImpl: SchoolDataSourceImpl

) : SchoolRepository {
    override  fun searchSchool(
        schoolName: String,
        type: String,
        index: String,
        size: String,
        key: String
    ): Single<SchoolResponseEntity> {
        return dataSourceImpl.searchSchool(schoolName, type, index, size, key).map {
            it.toDomain()
        }
    }
}
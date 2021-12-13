package com.example.data.repository.school.remote

import com.example.data.base.BaseDataSource
import com.example.data.entity.school.search.SearchSchoolResponse
import com.example.data.network.service.SchoolService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SchoolDataSourceImpl @Inject constructor(
    override val service: SchoolService
) : BaseDataSource<SchoolService>(), SchoolDataSource {
    override  fun searchSchool(
        schoolName: String,
        type: String,
        index: String,
        size: String,
        key: String
    ): Single<SearchSchoolResponse> {
        return service.searchSchool(schoolName,type,index,size,key)
    }

}
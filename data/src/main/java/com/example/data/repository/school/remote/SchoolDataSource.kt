package com.example.data.repository.school.remote

import com.example.data.entity.school.search.SearchSchoolResponse
import io.reactivex.rxjava3.core.Single

interface SchoolDataSource {
      fun searchSchool(schoolName: String,
                              type:String,
                              index:String,
                              size:String,
                              key:String
    ) : Single<SearchSchoolResponse>
}
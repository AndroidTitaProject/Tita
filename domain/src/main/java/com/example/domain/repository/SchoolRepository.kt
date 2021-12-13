package com.example.domain.repository

import com.example.domain.entity.school.SchoolInfoEntity
import com.example.domain.entity.school.SchoolResponseEntity
import io.reactivex.rxjava3.core.Single

interface SchoolRepository {
      fun searchSchool(schoolName: String,
                              type:String,
                              index:String,
                              size:String,
                              key:String
    ) : Single<SchoolResponseEntity>
}
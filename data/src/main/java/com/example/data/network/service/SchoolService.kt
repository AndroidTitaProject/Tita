package com.example.data.network.service

import com.example.data.entity.school.search.SearchSchoolResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolService {

    @GET("hub/schoolInfo")
     fun searchSchool(
        @Query(value = "SCHUL_NM") schoolName:String,
        @Query(value = "Type") type:String,
        @Query(value = "plndex") index: String,
        @Query(value = "pSize") size: String,
        @Query(value = "KEY") key:String
    ): Single<SearchSchoolResponse>
}
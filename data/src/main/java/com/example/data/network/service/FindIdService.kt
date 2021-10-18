package com.example.data.network.service

import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.entity.findpassword.response.PasswordMailResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface FindIdPasswordService {

    @POST("password/key")
    suspend fun postMailAndUserName(
        @Query("request") request : PasswordMailRequest
    ): Single<PasswordMailResponse>


}

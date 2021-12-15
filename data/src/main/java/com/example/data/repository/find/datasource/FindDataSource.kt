package com.example.data.repository.find.datasource

import com.example.data.base.BaseResponse
import com.example.data.entity.find.request.PasswordChangeRequest
import com.example.data.entity.find.request.PasswordMailRequest
import com.example.data.entity.find.response.PasswordChangeResponse
import com.example.data.entity.find.response.PasswordMailCodeResponse
import io.reactivex.rxjava3.core.Single

interface FindDataSource{
    suspend fun postPassword(request: PasswordMailRequest) : Single<BaseResponse>
    suspend fun getCode(code : String) : Single<PasswordMailCodeResponse>
    suspend fun putChangePassword(request: PasswordChangeRequest) : Single<PasswordChangeResponse>
}
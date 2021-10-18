package com.example.data.repository.signup.datasource

import com.example.data.base.BaseResponse
import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.entity.findpassword.response.PasswordMailResponse
import com.example.domain.entity.PostPasswordMailEntity
import io.reactivex.rxjava3.core.Single

interface FindPasswordDataSource{
    suspend fun postPassword(request: PasswordMailRequest) : Single<BaseResponse>
    suspend fun getCode(mail :String) : Single<PasswordMailResponse>
}
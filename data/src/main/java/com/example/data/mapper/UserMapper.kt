package com.example.data.mapper

import com.example.data.base.BaseResponse
import com.example.data.entity.findpassword.response.PasswordChangeResponse
import com.example.data.entity.findpassword.response.PasswordMailCodeResponse
import com.example.domain.entity.GetPasswordCodeEntity
import com.example.domain.entity.PostPasswordMailEntity
import com.example.domain.entity.PutChangePasswordEntity


fun BaseResponse.toDomain() : PostPasswordMailEntity{
    return PostPasswordMailEntity(
        this.success,
        this.code,
        this.msg
    )
}

fun PasswordChangeResponse.toDomain() : PutChangePasswordEntity{
    return PutChangePasswordEntity(
        this.success,
        this.code,
        this.msg
    )
}

fun PasswordMailCodeResponse.toDomain() : GetPasswordCodeEntity {
    return GetPasswordCodeEntity(
        this.success,
        this.code,
        this.msg
    )



}

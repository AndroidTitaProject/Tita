package com.example.data.mapper

import com.example.data.base.BaseResponse
import com.example.data.entity.find.response.PasswordChangeResponse
import com.example.data.entity.find.response.PasswordMailCodeResponse
import com.example.domain.entity.find.GetPasswordCodeEntity
import com.example.domain.entity.find.PostPasswordMailEntity
import com.example.domain.entity.find.PutChangePasswordEntity

fun BaseResponse.toFindDomain() : PostPasswordMailEntity {
    return PostPasswordMailEntity(
        this.success,
        this.code,
        this.msg
    )
}

fun PasswordChangeResponse.toDomain() : PutChangePasswordEntity {
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


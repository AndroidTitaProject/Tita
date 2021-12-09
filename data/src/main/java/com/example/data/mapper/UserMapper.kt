package com.example.data.mapper

import com.example.data.base.BaseResponse
import com.example.data.entity.signup.response.GetMailResponse
import com.example.data.entity.signup.response.IdCheckResponse
import com.example.data.entity.signup.response.NickNameOverlapResponse
import com.example.domain.entity.GetMailEntity
import com.example.domain.entity.IdCheckEntity
import com.example.domain.entity.NickNameEntity
import com.example.domain.entity.SignUpEntity


fun BaseResponse.toDomain(): SignUpEntity {
    return SignUpEntity(
        this.success,
        this.code,
        this.msg
    )
}


fun GetMailResponse.toDomain(): GetMailEntity {
    return GetMailEntity(
        this.success,
        this.code,
        this.msg
    )
}

fun IdCheckResponse.toDomain(): IdCheckEntity {
    return IdCheckEntity(
        this.success,
        this.code,
        this.msg,
        this.data,
    )
}

fun NickNameOverlapResponse.toDomain(): NickNameEntity {
    return NickNameEntity(
        this.success,
        this.code,
        this.msg,
        this.data,
    )
}
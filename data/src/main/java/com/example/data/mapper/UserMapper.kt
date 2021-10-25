package com.example.data.mapper

import com.example.data.base.FindIdPasswordBaseResponse
import com.example.data.base.SignUpBaseResponse
import com.example.data.entity.findpassword.response.PasswordChangeResponse
import com.example.data.entity.findpassword.response.PasswordMailCodeResponse
import com.example.data.entity.signup.response.GetMailResponse
import com.example.data.entity.signup.response.IdCheckResponse
import com.example.data.entity.signup.response.NickNameOverlapResponse
import com.example.domain.entity.*

fun SignUpBaseResponse.toDomain() : SignUpEntity{
    return SignUpEntity(
        this.success,
        this.code,
        this.msg
    )
}

fun FindIdPasswordBaseResponse.toDomain() : PostPasswordMailEntity{
    return PostPasswordMailEntity(
        this.success,
        this.code,
        this.msg
    )
}


fun GetMailResponse.toDomain() : GetMailEntity {
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


fun PasswordChangeResponse.toDomain() : PutChangePasswordEntity {
    return PutChangePasswordEntity(
        this.success,
        this.code,
        this.msg
    )
}

    fun PasswordMailCodeResponse.toDomain(): GetPasswordCodeEntity {
        return GetPasswordCodeEntity(
            this.success,
            this.code,
            this.msg
        )
    }

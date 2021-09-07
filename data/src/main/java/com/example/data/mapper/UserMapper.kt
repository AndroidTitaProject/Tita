package com.example.data.mapper

import com.example.data.entity.GetMailDto
import com.example.data.entity.SignUpDto
import com.example.domain.entity.response.GetMailEntity
import com.example.domain.entity.response.SignUpEntity

fun SignUpEntity.toData(): SignUpDto {
    return SignUpDto(
        this.success,
        this.code,
        this.msg
    )
}

fun SignUpDto.toEntity():SignUpEntity {
    return SignUpEntity(
        this.success,
        this.code,
        this.msg
    )
}

fun GetMailDto.toEntity() : GetMailEntity{
    return GetMailEntity(
        this.success,
        this.code,
        this.msg
    )
}

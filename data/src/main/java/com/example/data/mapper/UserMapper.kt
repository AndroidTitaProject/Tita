package com.example.data.mapper

import com.example.data.base.BaseResponse
import com.example.domain.entity.PostPasswordMailEntity



fun BaseResponse.toDomain() : PostPasswordMailEntity{
    return PostPasswordMailEntity(
        this.success,
        this.code,
        this.msg
    )
}



//fun GetMailResponse.toDomain() : GetMailEntity {
//    return GetMailEntity(
//        this.success,
//        this.code,
//        this.msg
//    )
//}

package com.example.data.mapper

import com.example.data.entity.board.response.BoardResponse
import com.example.domain.entity.BoardEntity

fun BoardResponse.toDomain(): BoardEntity {
    return BoardEntity(
        this.code,
        this.data,
        this.msg,
        this.success
    )
}
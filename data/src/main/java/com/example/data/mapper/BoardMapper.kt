package com.example.data.mapper

import com.example.data.entity.board.response.BoardData
import com.example.data.entity.board.response.BoardResponse
import com.example.domain.entity.BoardEntity
import com.google.gson.annotations.SerializedName

fun BoardResponse.toDomain(): BoardEntity {
    return BoardEntity(
        this.code,
        this.data.map { it.toEntity() },
        this.msg,
        this.success
    )
}

fun BoardData.toEntity() : com.example.domain.entity.BoardData {
    return com.example.domain.entity.BoardData(
        this.content,
        this.postName
    )
}
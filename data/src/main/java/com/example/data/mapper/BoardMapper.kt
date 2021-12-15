package com.example.data.mapper

import com.example.data.entity.board.request.BoardFreePostRequest
import com.example.data.entity.board.response.BoardData
import com.example.data.entity.board.response.BoardFreeResponse
import com.example.data.entity.board.response.BoardResponse
import com.example.domain.entity.BoardEntity
import com.example.domain.entity.BoardFreePost
import com.example.domain.entity.BoardFreePostEntity
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

fun BoardFreeResponse.toDomain() : BoardFreePost{
    return BoardFreePost(
        this.success,
        this.code,
        this.msg
    )
}

fun BoardFreePostEntity.toEntity() : BoardFreePostRequest{
    return BoardFreePostRequest(
        this.content,
        this.postName
    )
}
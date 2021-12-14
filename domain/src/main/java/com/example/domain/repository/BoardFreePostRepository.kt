package com.example.domain.repository

import com.example.domain.entity.BoardFreePost
import com.example.domain.entity.BoardFreePostEntity
import io.reactivex.rxjava3.core.Single

interface BoardFreePostRepository {
    suspend fun boardFreePost(boardLocation : String,boardFreePostRequest : BoardFreePostEntity) : Single<BoardFreePost>
}
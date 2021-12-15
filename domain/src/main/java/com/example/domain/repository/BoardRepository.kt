package com.example.domain.repository

import com.example.domain.entity.*
import io.reactivex.rxjava3.core.Single

interface BoardRepository {
    suspend fun getPost(postLocation : String) : Single<BoardEntity>
    suspend fun boardFreePost(boardLocation : String,boardFreePostRequest : BoardFreePostEntity) : Single<BoardFreePost>
}
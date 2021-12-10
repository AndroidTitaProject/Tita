package com.example.domain.repository

import com.example.domain.entity.BoardData
import com.example.domain.entity.BoardEntity
import com.example.domain.entity.LoginEntity
import io.reactivex.rxjava3.core.Single

interface BoardRepository {
    suspend fun getPost(postLocation : String) : Single<BoardEntity>
}
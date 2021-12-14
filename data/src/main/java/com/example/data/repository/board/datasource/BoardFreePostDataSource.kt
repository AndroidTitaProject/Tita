package com.example.data.repository.board.datasource

import com.example.data.entity.board.request.BoardFreePostRequest
import com.example.data.entity.board.response.BoardFreeResponse
import com.example.data.entity.board.response.BoardResponse
import io.reactivex.rxjava3.core.Single

interface BoardFreePostDataSource{
    suspend fun boardFreePost(boardLocation : String,boardFreePostRequest : BoardFreePostRequest) : Single<BoardFreeResponse>
}
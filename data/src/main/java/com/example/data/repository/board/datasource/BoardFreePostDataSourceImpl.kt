package com.example.data.repository.board.datasource

import com.example.data.base.BaseDataSource
import com.example.data.entity.board.request.BoardFreePostRequest
import com.example.data.entity.board.response.BoardFreeResponse
import com.example.data.entity.board.response.BoardResponse
import com.example.data.network.service.BoardService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BoardFreePostDataSourceImpl @Inject constructor(

    override val service: BoardService

) : BaseDataSource<BoardService>(),
    BoardFreePostDataSource {
    override suspend fun boardFreePost(
        boardLocation: String,
        boardFreePostRequest: BoardFreePostRequest
    ): Single<BoardFreeResponse> {
       return service.postFreeBoard(boardLocation,boardFreePostRequest)
    }


}
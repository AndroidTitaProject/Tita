package com.example.data.repository.board.datasource

import android.util.Log
import com.example.data.base.BaseDataSource
import com.example.data.entity.board.request.BoardFreePostRequest
import com.example.data.entity.board.response.BoardData
import com.example.data.entity.board.response.BoardFreeResponse
import com.example.data.entity.board.response.BoardResponse
import com.example.data.network.service.BoardService
import com.example.data.network.service.FindIdPasswordService
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BoardDataSourceImpl @Inject constructor(
    override val service: BoardService

) : BaseDataSource<BoardService>(),
    BoardDataSource {

    override suspend fun getPost(boardLocation: String): Single<BoardResponse> {
        return service.getPost(boardLocation)
    }

    override suspend fun boardFreePost(
        boardLocation: String,
        boardFreePostRequest: BoardFreePostRequest
    ): Single<BoardFreeResponse> {
        return service.postFreeBoard(boardLocation,boardFreePostRequest)
    }
}
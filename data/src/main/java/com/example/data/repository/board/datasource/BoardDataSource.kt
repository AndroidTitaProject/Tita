package com.example.data.repository.board.datasource

import com.example.data.base.FindIdPasswordBaseResponse
import com.example.data.entity.board.response.BoardResponse
import com.example.data.entity.findpassword.request.PasswordMailRequest
import io.reactivex.rxjava3.core.Single

interface BoardDataSource {
    suspend fun getPost(boardLocation : String) : Single<BoardResponse>
}
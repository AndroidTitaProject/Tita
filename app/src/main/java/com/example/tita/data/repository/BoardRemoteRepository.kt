package com.example.tita.data.repository

import com.example.tita.data.model.BoardData
import com.example.tita.data.network.BoardApiInterface
import com.example.tita.data.network.LoginApiInterface
import retrofit2.Response
import javax.inject.Inject

class BoardRemoteRepository  @Inject constructor(
    private val BoardApiInterface : BoardApiInterface
){
    suspend fun postBoard(board : String, boardDetail : String, title : String, Contents : String) : Response<BoardData> {
        return BoardApiInterface.postBoard(board,boardDetail,title,Contents)
    }
}
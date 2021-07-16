package com.example.tita.data.network

import com.example.tita.data.model.BoardData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface BoardApiInterface {
    //게시판 요청
    @POST("forum/free/write")
    fun postBoard(
        @Body board : String,
        @Body boardDetail : String,
        @Body title : String,
        @Body Contents : String
    ): Response<BoardData>
}
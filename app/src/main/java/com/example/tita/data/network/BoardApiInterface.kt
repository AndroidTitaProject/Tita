package com.example.tita.data.network

import android.widget.AdapterView
import com.example.tita.data.model.BoardData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface BoardApiInterface {
    //게시판 요청
    @POST("forum/free/write")
    fun postBoard(
        @Field("board") board: String,
        @Field("boardDetail") boardDetail: String,
        @Field("title") title: String,
        @Field("contents") contents: String
    ): Response<BoardData>
}
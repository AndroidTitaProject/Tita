package com.example.data.network.service

import com.example.data.entity.board.request.BoardFreePostRequest
import com.example.data.entity.board.response.BoardFreeResponse
import com.example.data.entity.board.response.BoardResponse
import com.example.data.entity.login.request.LoginRequest
import com.example.data.entity.login.response.LoginResponse
import com.example.data.entity.signup.response.IdCheckResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BoardService {

    @GET("/tita/forum/{board}/list")
    fun getPost(
       @Path("board") boardLocation : String
    ): Single<BoardResponse>

    @POST("/tita/forum/{board}/create")
    fun postFreeBoard(
        @Path("board") boardLocation : String,
        @Body body : BoardFreePostRequest
    ): Single<BoardFreeResponse>

}
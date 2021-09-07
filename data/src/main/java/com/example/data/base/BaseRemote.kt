package com.example.data.base

import com.example.data.util.Response
import com.google.gson.Gson
import io.reactivex.rxjava3.functions.Function

// SV 에 api를 넣어준다.
// 실패, 성공, 메세지 등 함수
abstract class BaseRemote<SV> {
    abstract val service: SV

    fun <T> getResponse(): Function<retrofit2.Response<Response<T>>, T> {
        return Function {
            checkError(it)
            it.body()!!.data
        }
    }

    fun <T> getMessage(): Function<retrofit2.Response<Response<T>>, String> {
        return Function {
            checkError(it)
            it.body()!!.message
        }
    }

    private fun <T> checkError(response: retrofit2.Response<Response<T>>) {
        if (!response.isSuccessful) {
            val gson = Gson()
            val errorBody = gson.fromJson(response.errorBody()!!.charStream(), Response::class.java)
            throw Throwable(errorBody.message)
        }
    }
}
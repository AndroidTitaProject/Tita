package com.example.tita.data.repository

import com.example.tita.data.model.Signupdata
import com.example.tita.data.network.LoginApiInterface
import retrofit2.Response
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val loginApiInterface: LoginApiInterface
) {
    suspend fun postLogin(id: String, pwd: String): Response<Signupdata> {
        return loginApiInterface.postLogin(id, pwd)
    }
}
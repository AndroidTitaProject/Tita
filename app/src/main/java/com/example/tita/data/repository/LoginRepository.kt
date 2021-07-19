package com.example.tita.data.repository

import com.example.tita.data.model.LoginData
import com.example.tita.data.network.LoginApiInterface
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginApiInterface: LoginApiInterface
) {
    suspend fun postLogin(id: String, pwd: String): Response<LoginData> {
        return loginApiInterface.postLogin(id, pwd)
    }
}
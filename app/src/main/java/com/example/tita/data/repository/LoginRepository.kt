package com.example.tita.data.repository

import com.example.tita.data.network.dto.LoginData
import com.example.tita.data.network.LoginApiInterface
import com.example.tita.data.network.dto.MailData
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginApiInterface: LoginApiInterface
) {
    suspend fun postLogin(id: String, pwd: String): Response<LoginData> {
        return loginApiInterface.postLogin(id, pwd)
    }

    suspend fun postMail(mail: String): Response<MailData> {
        return loginApiInterface.postMail(mail)
    }
}
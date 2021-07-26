package com.example.tita.data.repository

import com.example.tita.data.network.SignUpInterface
import com.example.tita.data.network.dto.MailData
import com.example.tita.data.network.dto.UserNameData
import retrofit2.Response
import javax.inject.Inject

class SignUpRepository @Inject constructor(
    private val signUpInterface: SignUpInterface
) {
    suspend fun postMail(mail: String): Response<MailData> {
        return signUpInterface.postMail(mail)
    }

    suspend fun postUserName(username: String): Response<UserNameData> {
        return signUpInterface.postUserName(username,"")
    }
}
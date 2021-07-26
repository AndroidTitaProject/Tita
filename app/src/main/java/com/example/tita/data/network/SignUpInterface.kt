package com.example.tita.data.network

import com.example.tita.BuildConfig.BASE_URL
import com.example.tita.data.network.dto.MailCertifiedData
import com.example.tita.data.network.dto.MailData
import com.example.tita.data.network.dto.SignUpdData
import com.example.tita.data.network.dto.UserNameData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.logging.Level

interface SignUpInterface {

    @POST
    fun postSignUp(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("address") address: String,


        ): Response<SignUpdData>


    @FormUrlEncoded
    @POST("user/verify")
    suspend fun postMail(
        @Field("mail") mail: String
    ): Response<MailData>


    @POST("user/verify/{key}")
    fun getPasswordMail(
        @Path("key") key: String
    ): Response<MailCertifiedData>

    @POST("username/{username}/exists")
   suspend fun postUserName(
        @Path("username") username: String,
        @Query("message") message:String
    ) : Response<UserNameData>


}

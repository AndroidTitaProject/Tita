package com.example.tita.data.di

import android.content.ContentValues
import android.util.Log
import com.example.tita.BuildConfig
import com.example.tita.data.network.LoginApiInterface
import com.example.tita.data.network.SignUpInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        Log.d(ContentValues.TAG, "provideHttpClient: ")
        return OkHttpClient.Builder()
            //서버로부터의 응답까지의 시간이 읽기 시간 초과보다 크면 요청 실패로 판단한다.
            .readTimeout(15, TimeUnit.SECONDS)
            //서버로 요청을 시작한 후 15초가 지날 때 까지 데이터가 안오면 에러로 판단한다.
            .connectTimeout(15, TimeUnit.SECONDS)
            // 얼마나 빨리 서버로 데이터를 받을 수 있는지 판단한다.
            .writeTimeout(15, TimeUnit.SECONDS)
            .// 이 클라이언트를 통해 오고 가는 네트워크 요청/응답을 로그로 표시하도록 합니다.
            addInterceptor(getLoggingInterceptor())
            .build()

    }


    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            //json 변화기 Factory
            .client(provideHttpClient())
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    // LoginInterface
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): LoginApiInterface {
        Log.d(ContentValues.TAG, "provideApiService: ")
        return retrofit.create(LoginApiInterface::class.java)
    }

    // SignUpInterface
    @Provides
    @Singleton
    fun provideSignUpeApiService(retrofit: Retrofit): SignUpInterface {
        Log.d(ContentValues.TAG, "provideApiService: ")
        return retrofit.create(SignUpInterface::class.java)
    }

    // 서버로 부터 받아온 데이터 log 찍기
    private fun getLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }


}
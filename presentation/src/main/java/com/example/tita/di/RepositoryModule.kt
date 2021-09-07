package com.example.tita.di

import com.example.data.datasource.RemoteSignUpDataSource
import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(authDataSource: RemoteSignUpDataSource): AuthRepository {
        return AuthRepositoryImpl(authDataSource)
    }

}
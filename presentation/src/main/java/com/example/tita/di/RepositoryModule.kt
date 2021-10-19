package com.example.tita.di

import com.example.data.repository.findidpassword.repository.FindPasswordRepositoryImpl
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSource
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSourceImpl
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
    fun provideAuthRepository(authDataSourceImpl: FindPasswordDataSourceImpl): AuthRepository {
        return FindPasswordRepositoryImpl(authDataSourceImpl)
    }

}
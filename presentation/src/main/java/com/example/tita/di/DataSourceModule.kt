package com.example.tita.di

import com.example.data.network.service.FindIdPasswordService
import com.example.data.repository.signup.datasource.FindPasswordDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideUserDataSource(authRemote: FindIdPasswordService): FindPasswordDataSource {
        return FindPasswordDataSource(authRemote)
    }


}
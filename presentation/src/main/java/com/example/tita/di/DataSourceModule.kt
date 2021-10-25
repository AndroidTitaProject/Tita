package com.example.tita.di

import com.example.data.network.service.FindIdPasswordService
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSourceImpl
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
    fun provideUserDataSource(authRemote: FindIdPasswordService): FindPasswordDataSourceImpl {
        return FindPasswordDataSourceImpl(authRemote)
    }


}
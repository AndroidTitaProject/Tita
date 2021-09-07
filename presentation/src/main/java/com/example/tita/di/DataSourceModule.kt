package com.example.tita.di

import com.example.data.datasource.RemoteSignUpDataSource
import com.example.data.network.remote.AuthRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideUserDataSource(authRemote: AuthRemote): RemoteSignUpDataSource {
        return RemoteSignUpDataSource(authRemote)
    }


}
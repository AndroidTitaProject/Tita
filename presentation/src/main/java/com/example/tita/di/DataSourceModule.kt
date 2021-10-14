package com.example.tita.di

import com.example.data.repository.signup.remote.SignUpDataSourceImpl
import com.example.data.network.service.SignUpService
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
    fun provideUserDataSource(authRemote: SignUpService): SignUpDataSourceImpl {
        return SignUpDataSourceImpl(authRemote)
    }


}
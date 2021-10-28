package com.example.tita.di


import com.example.data.network.service.LoginService
import com.example.data.repository.login.datasource.LoginDataSourceImpl
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
    fun provideLoginDataSource(service: LoginService): LoginDataSourceImpl {
        return LoginDataSourceImpl(service)
    }

}
















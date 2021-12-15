package com.example.tita.di

import com.example.data.network.service.FindService
import com.example.data.network.service.SchoolService
import com.example.data.repository.signup.remote.SignUpDataSourceImpl
import com.example.data.network.service.SignUpService
import com.example.data.repository.school.remote.SchoolDataSourceImpl
import com.example.data.repository.find.datasource.FindDataSourceImpl
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
    fun provideSignUpDataSource(authRemote: SignUpService): SignUpDataSourceImpl {
        return SignUpDataSourceImpl(authRemote)
    }

    @Provides
    @Singleton
    fun provideSchoolDataSource(authRemote: SchoolService): SchoolDataSourceImpl {
        return SchoolDataSourceImpl(authRemote)

    }
    @Provides
    @Singleton
    fun provideUserDataSource(findRemote: FindService): FindDataSourceImpl {
        return FindDataSourceImpl(findRemote)
    }
}
















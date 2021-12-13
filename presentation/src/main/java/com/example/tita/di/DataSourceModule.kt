package com.example.tita.di

import com.example.data.network.service.FindIdPasswordService
import com.example.data.network.service.SchoolService
import com.example.data.network.service.BoardService
import com.example.data.repository.signup.remote.SignUpDataSourceImpl
import com.example.data.network.service.SignUpService
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSourceImpl

import com.example.data.network.service.LoginService
import com.example.data.repository.board.datasource.BoardDataSourceImpl
import com.example.data.repository.login.datasource.LoginDataSourceImpl
import com.example.data.repository.school.remote.SchoolDataSourceImpl
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

    @Provides
    @Singleton
    fun provideLoginDataSource(service: LoginService): LoginDataSourceImpl {
        return LoginDataSourceImpl(service)
    }
    @Provides
    @Singleton
    fun provideSchoolDataSource(authRemote: SchoolService): SchoolDataSourceImpl {
        return SchoolDataSourceImpl(authRemote)
    }

    @Provides
    @Singleton
    fun provideBoardDataSource(service: BoardService): BoardDataSourceImpl {
        return BoardDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideUserFindIdPasswordDataSource(authRemote: FindIdPasswordService): FindPasswordDataSourceImpl {
        return FindPasswordDataSourceImpl(authRemote)
    }

}





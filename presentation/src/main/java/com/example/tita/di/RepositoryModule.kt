package com.example.tita.di

import com.example.data.repository.findidpassword.datasource.FindPasswordDataSourceImpl
import com.example.data.repository.findidpassword.repository.FindPasswordRepositoryImpl
import com.example.data.repository.login.datasource.LoginDataSourceImpl
import com.example.data.repository.login.repository.LoginRepositoryImpl
import com.example.data.repository.school.SchoolSearchRepositoryImpl
import com.example.data.repository.school.remote.SchoolDataSourceImpl
import com.example.data.repository.signup.remote.SignUpDataSourceImpl
import com.example.data.repository.signup.SignUpRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.FindIdAndPasswordRepository
import com.example.domain.repository.LoginRepository
import com.example.domain.repository.SchoolRepository
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
    fun provideFindIdPasswordRepository(FindPasswordDataSourceImpl: FindPasswordDataSourceImpl): FindIdAndPasswordRepository {
        return FindPasswordRepositoryImpl(FindPasswordDataSourceImpl)
    }
    @Provides
    @Singleton
    fun provideAuthRepository(authDataSourceImpl: SignUpDataSourceImpl): AuthRepository {
        return SignUpRepositoryImpl(authDataSourceImpl)
    }
    @Provides
    @Singleton
    fun provideSchoolRepository(authDataSourceImpl: SchoolDataSourceImpl): SchoolRepository {
        return SchoolSearchRepositoryImpl(authDataSourceImpl)
    }
    @Provides
    @Singleton
    fun provideLoginRepository(loginDataSourceImpl: LoginDataSourceImpl) : LoginRepository {
        return LoginRepositoryImpl(loginDataSourceImpl)
    }


}
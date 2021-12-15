package com.example.tita.di

import com.example.data.repository.find.datasource.FindDataSourceImpl
import com.example.data.repository.find.repository.FindRepositoryImpl
import com.example.data.repository.school.SchoolSearchRepositoryImpl
import com.example.data.repository.school.remote.SchoolDataSourceImpl
import com.example.data.repository.signup.remote.SignUpDataSourceImpl
import com.example.data.repository.signup.SignUpRepositoryImpl
import com.example.domain.repository.FindRepository
import com.example.domain.repository.SignUpRepository
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
    fun provideAuthRepository(authDataSourceImpl: SignUpDataSourceImpl): SignUpRepository {
        return SignUpRepositoryImpl(authDataSourceImpl)
    }
    @Provides
    @Singleton
    fun provideSchoolRepository(authDataSourceImpl: SchoolDataSourceImpl): SchoolRepository {
        return SchoolSearchRepositoryImpl(authDataSourceImpl)
    }
    @Provides
    @Singleton
    fun provideFindRepository(authDataSourceImpl: FindDataSourceImpl): FindRepository {
        return FindRepositoryImpl(authDataSourceImpl)
    }
}
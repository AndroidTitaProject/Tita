package com.example.data.repository.login.repository

import com.example.data.entity.login.request.LoginRequest
import com.example.data.mapper.toDomain
import com.example.data.repository.login.datasource.LoginDataSource
import com.example.domain.entity.LoginEntity
import com.example.domain.repository.LoginRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val dataSource: LoginDataSource) : LoginRepository {


    override suspend fun login(id: String, password: String): Single<LoginEntity> {
        return dataSource.login(LoginRequest(id, password)).map { it.toDomain() }
    }
}
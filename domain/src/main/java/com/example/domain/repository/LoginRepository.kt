package com.example.domain.repository

import com.example.domain.entity.LoginEntity
import io.reactivex.rxjava3.core.Single

interface LoginRepository {
    suspend fun login(id : String, password:String) :  Single<LoginEntity>
}
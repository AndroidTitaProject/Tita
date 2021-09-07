package com.example.data.network.remote

import com.example.data.base.BaseRemote
import com.example.data.entity.GetMailDto
import com.example.data.entity.SignUpDto
import com.example.data.network.service.UserApi
import com.example.domain.entity.request.SignUpRequest
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AuthRemote @Inject constructor(override val service: UserApi) :
    BaseRemote<UserApi>() {

    suspend fun postSignUp(signUpRequest: SignUpRequest): Single<SignUpDto> {
        with(signUpRequest) {
            return service.postSignUp(
                username, password, name, school, email
            ).map(getResponse())
        }
    }

    suspend fun getEmail(mail:String) : Single<GetMailDto>{
        with(mail){
            return service.getMail(
                this
            ).map(getResponse())
        }

    }

}
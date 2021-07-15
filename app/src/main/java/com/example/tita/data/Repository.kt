package com.example.tita.data

import retrofit2.Call
import retrofit2.Response

class Repository {
    fun postSignupEmail(email : String){
        val postemail = Client.service.signup()

        postemail.enqueue(object : retrofit2.Callback<Signupdata>{
            override fun onResponse(call: Call<Signupdata>, response: Response<Signupdata>) {
                //post 성공!
                if(response.isSuccessful)
                {

                }

            }

            override fun onFailure(call: Call<Signupdata>, t: Throwable) {

                //post 실패!
            }

        })
    }
}
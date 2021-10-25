package com.example.data.entity.signup.request

import com.google.gson.annotations.SerializedName

data class GetMailRequest(@SerializedName("username")val mail : String)
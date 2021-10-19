package com.example.data.entity.findpassword.request

import com.google.gson.annotations.SerializedName

data class GetMailCodeRequest(
    @SerializedName("code")val code : String
)
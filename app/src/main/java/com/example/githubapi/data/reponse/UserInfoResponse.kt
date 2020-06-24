package com.example.githubapi.data.reponse

import com.google.gson.annotations.SerializedName

data class UserInfoResponse(
    @SerializedName("avatar_url") val avatar_url: String?,
    @SerializedName("name") val name: String?
)
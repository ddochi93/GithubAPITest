package com.example.githubapi.data.reponse

import com.google.gson.annotations.SerializedName


data class UserRepoInfoResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val node_id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("stargazers_count") val stargazers_count: Int
    )
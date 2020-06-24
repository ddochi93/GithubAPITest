package com.example.githubapi.api.service

import com.example.githubapi.data.reponse.UserInfoResponse
import com.example.githubapi.data.reponse.UserRepoInfoResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserInfoService {
    @GET("{username}")
    fun getUserInfo(@Path("username") username: String): Single<UserInfoResponse>

    @GET("{username}/repos")
    fun getUserRepoInfo(@Path("username") username: String): Single<List<UserRepoInfoResponse>>
}
package com.example.githubapi.api.usecase

import com.example.githubapi.api.service.UserInfoService
import com.example.githubapi.data.reponse.UserInfoResponse
import com.example.githubapi.data.reponse.UserRepoInfoResponse
import com.example.githubapi.koin.repository.AccessRetrofitRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetUserRepoInfoUsecase(accessRetrofitRepository: AccessRetrofitRepository) {
    private val userInfoService = accessRetrofitRepository
        .getAccessRetrofit()
        .create(UserInfoService::class.java)

    fun getUserRepoInfo(username: String) : Single<List<UserRepoInfoResponse>> = userInfoService
        .getUserRepoInfo(username)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
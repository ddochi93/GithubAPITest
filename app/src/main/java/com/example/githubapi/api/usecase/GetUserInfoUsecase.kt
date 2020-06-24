package com.example.githubapi.api.usecase

import com.example.githubapi.api.service.UserInfoService
import com.example.githubapi.data.reponse.UserInfoResponse
import com.example.githubapi.koin.repository.AccessRetrofitRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetUserInfoUsecase(accessRetrofitRepository: AccessRetrofitRepository) {
    private val userInfoService = accessRetrofitRepository
        .getAccessRetrofit()
        .create(UserInfoService::class.java)

    fun getUserInfo(username: String) : Single<UserInfoResponse> = userInfoService
        .getUserInfo(username)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
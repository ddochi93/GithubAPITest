package com.example.githubapi

import com.example.githubapi.api.usecase.GetUserInfoUsecase
import com.example.githubapi.api.usecase.GetUserRepoInfoUsecase

interface GithubContract {
    interface View {
        fun setUserInfo()
        fun setUserRepoList()
    }

    interface Presenter {
        val view: View
        val getUserInfoUsecase: GetUserInfoUsecase
        val getUserRepoInfoUsecase: GetUserRepoInfoUsecase

        fun getUserInfo()
        fun getUserRepoList()
    }
}
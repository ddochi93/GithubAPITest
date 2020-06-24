package com.example.githubapi

import com.example.githubapi.api.usecase.GetUserInfoUsecase
import com.example.githubapi.api.usecase.GetUserRepoInfoUsecase
import com.example.githubapi.data.entity.UserRepoInfoVO

interface GithubContract {
    interface View {
        fun setView(userRepoInfoList: ArrayList<UserRepoInfoVO>)
        fun setRepoInfo()
    }

    interface Presenter {
        val view: View

        fun getUserInfo(username:String)
        fun getUserRepoList(username:String)
    }
}
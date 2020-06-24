package com.example.githubapi

import com.example.githubapi.api.usecase.GetUserInfoUsecase
import com.example.githubapi.api.usecase.GetUserRepoInfoUsecase

class GithubPresenter(override val view: GithubContract.View,
                      override val getUserInfoUsecase: GetUserInfoUsecase,
                      override val getUserRepoInfoUsecase: GetUserRepoInfoUsecase
) : GithubContract.Presenter {

    override fun getUserInfo() {

    }

    override fun getUserRepoList() {

    }

}
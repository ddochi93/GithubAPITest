package com.example.githubapi

import android.annotation.SuppressLint
import android.util.Log
import com.example.githubapi.api.usecase.GetUserInfoUsecase
import com.example.githubapi.api.usecase.GetUserRepoInfoUsecase
import com.example.githubapi.data.entity.UserInfoRepoInfo
import com.example.githubapi.data.entity.UserInfoVO
import com.example.githubapi.data.entity.UserRepoInfoVO
import com.example.githubapi.data.entity.ViewType
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList

class GithubPresenter(override val view: GithubContract.View,
                      private val getUserInfoUsecase: GetUserInfoUsecase,
                      private val getUserRepoInfoUsecase: GetUserRepoInfoUsecase
) : GithubContract.Presenter {

    private var userRepoInfoList: ArrayList<UserRepoInfoVO> = ArrayList()

    @SuppressLint("CheckResult")
    override fun getUserInfo(username: String) {
        getUserInfoUsecase.getUserInfo(username).subscribe({
            userRepoInfoList.add(UserRepoInfoVO(it.avatar_url, it.name, null , null, null, ViewType.userInfo))
        }, {
            Timber.e(it.localizedMessage)
        })

    }

    @SuppressLint("CheckResult")
    override fun getUserRepoList(username:String) {
        val tempList: ArrayList<UserRepoInfoVO> = ArrayList()
        getUserRepoInfoUsecase.getUserRepoInfo(username).subscribe({
            for( repoInfo in it) {
                tempList.add(UserRepoInfoVO(null, null, repoInfo.name, repoInfo.description, repoInfo.stargazers_count, ViewType.repoInfo))
            }
        }, {
            Timber.e(it.localizedMessage)
        })
        tempList.sortedWith(compareByDescending{it.starCount})
        userRepoInfoList.addAll(tempList)
        view.setView(userRepoInfoList)
    }

}
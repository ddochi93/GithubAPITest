package com.example.githubapi.koin.modules

import com.example.githubapi.api.usecase.GetUserInfoUsecase
import com.example.githubapi.api.usecase.GetUserRepoInfoUsecase
import org.koin.dsl.module

val usecaseModule = module {
    factory { GetUserInfoUsecase(get()) }
    factory { GetUserRepoInfoUsecase(get()) }
}
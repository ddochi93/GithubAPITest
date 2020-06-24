package com.example.githubapi.koin.modules

import com.example.githubapi.koin.repository.AccessRetrofitRepository
import com.example.githubapi.koin.repositoryImpl.AccessRetrofitRepositoryImpl
import org.koin.dsl.module

val networkMudule = module {
    single<AccessRetrofitRepository> { AccessRetrofitRepositoryImpl() }

}
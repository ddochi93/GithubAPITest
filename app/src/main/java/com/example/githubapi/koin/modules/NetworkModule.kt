package com.example.githubapi.koin.modules

import org.koin.dsl.module

val networkMudule = module {
    single<AccessRetrofitRepository> { AccessRetrofitRepositoryImpl() }

}
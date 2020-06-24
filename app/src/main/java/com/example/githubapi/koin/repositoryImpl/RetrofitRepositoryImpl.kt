package com.example.githubapi.koin.repositoryImpl

import com.example.githubapi.globalconst.Consts
import com.example.githubapi.koin.repository.AccessRetrofitRepository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AccessRetrofitRepositoryImpl(): AccessRetrofitRepository {
    override fun getAccessRetrofit(): Retrofit {
        val  baseUrl: String = Consts.BASE_URL
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}
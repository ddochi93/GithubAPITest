package com.example.githubapi.koin.repository

import retrofit2.Retrofit

interface AccessRetrofitRepository {
    fun getAccessRetrofit(): Retrofit
}
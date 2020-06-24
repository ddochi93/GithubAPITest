package com.example.githubapi

import android.app.Application
import com.example.githubapi.koin.modules.networkMudule
import com.example.githubapi.koin.modules.usecaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GithubApplication)
            modules(listOf(networkMudule, usecaseModule))
        }
    }
}
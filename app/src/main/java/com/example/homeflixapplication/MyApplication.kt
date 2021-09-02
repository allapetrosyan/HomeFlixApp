package com.example.homeflixapplication

import android.app.Application
import com.example.homeflixapplication.DmModule.Companion.apiModule
import com.example.homeflixapplication.DmModule.Companion.networkModule
import com.example.homeflixapplication.DmModule.Companion.repositoryModule
import com.example.homeflixapplication.DmModule.Companion.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                apiModule,
                viewModelModule,
                repositoryModule,
                networkModule
            )
        }
    }
}
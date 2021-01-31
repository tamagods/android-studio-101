package com.example.myandroid

import android.app.Application
import com.example.myandroid.di.appModule
import com.example.myandroid.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            androidContext(this@MyApp)
            modules(
                networkModule,
                appModule
            )
        }
    }
}
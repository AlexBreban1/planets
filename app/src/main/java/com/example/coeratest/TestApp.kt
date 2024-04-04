package com.example.coeratest

import android.app.Application
import com.example.coeratest.di.appModule
import com.example.coeratest.di.dataBaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(androidContext = this@TestApp)
            modules(
                appModule, dataBaseModule
            )
        }
    }
}
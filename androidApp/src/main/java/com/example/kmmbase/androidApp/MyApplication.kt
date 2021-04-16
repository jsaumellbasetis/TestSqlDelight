package com.example.kmmbase.androidApp

import android.app.Application
import com.example.kmmbase.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@MyApplication)
            // modules(appModule)
        }
    }
}

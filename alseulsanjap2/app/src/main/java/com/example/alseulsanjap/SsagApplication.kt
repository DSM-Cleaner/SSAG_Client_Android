package com.example.alseulsanjap

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SsagApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SsagApplication)
            modules(
                listOf(
                    certificationModule
                )
            )
        }
        context = applicationContext
    }

    companion object {
        lateinit var context: Context
            private set
    }
}
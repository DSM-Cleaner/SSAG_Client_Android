package com.example.alseulsanjap.di

import com.example.alseulsanjap.SharedPreferenceStorage
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val mainModule = module {
    single { SharedPreferenceStorage(androidApplication()) }
}
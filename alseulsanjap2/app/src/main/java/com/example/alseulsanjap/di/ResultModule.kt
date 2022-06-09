package com.example.alseulsanjap.di

import com.example.alseulsanjap.CheckResultImpl
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val resultModule = module {
    viewModel { CheckResultViewModel() }
    single { CheckResultImpl() }
}
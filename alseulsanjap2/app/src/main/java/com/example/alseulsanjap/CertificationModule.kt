package com.example.alseulsanjap

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val certificationModule = module {
    viewModel { CertificationViewModel() }
}
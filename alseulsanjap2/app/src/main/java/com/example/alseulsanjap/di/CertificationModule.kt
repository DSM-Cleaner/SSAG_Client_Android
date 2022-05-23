package com.example.alseulsanjap

import com.example.alseulsanjap.certification.CertificationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val certificationModule = module {
    viewModel { CertificationViewModel() }
    single { CertificationImpl() }
}
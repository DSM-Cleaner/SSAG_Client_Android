package com.example.alseulsanjap

import retrofit2.Response

interface CertificationRepository {
    suspend fun doCertification(code: CertificationRequest): Response<CertificationResponse>
}
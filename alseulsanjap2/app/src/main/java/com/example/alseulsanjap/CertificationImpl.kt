package com.example.alseulsanjap

import com.example.alseulsanjap.util.ApiProvider
import retrofit2.Response

class CertificationImpl : CertificationRepository,SafeCallRequest() {
    override suspend fun doCertification(code: CertificationRequest): Response<CertificationResponse> {
        return safeApiCall { ApiProvider.getAPI().doCertification(code) }
    }
}
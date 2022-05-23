package com.example.alseulsanjap

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface SsagAPI {
    @GET("/user/login")
    suspend fun doCertification(
        @Body code: CertificationRequest
    ): Response<CertificationResponse>

}
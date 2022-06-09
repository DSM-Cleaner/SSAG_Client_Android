package com.example.alseulsanjap

import retrofit2.Response
import retrofit2.http.*

interface SsagAPI {
    @POST("/user/login")
    suspend fun doCertification(
        @Body code: CertificationRequest
    ): Response<CertificationResponse>

    @GET("/cleaning/{student_id}")
    suspend fun getCleanWeekData(
        @Header("Authorization") accessToken : String,
        @Path("student_id") student_id :Int
    ):Response<CleanWeekResponse>
}
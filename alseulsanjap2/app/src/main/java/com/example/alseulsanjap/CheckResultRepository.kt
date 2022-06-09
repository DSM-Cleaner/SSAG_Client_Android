package com.example.alseulsanjap

import retrofit2.Response

interface CheckResultRepository  {
    suspend fun getCleanWeekData(accessToken : String,studentId : Int): Response<CleanWeekResponse>
}
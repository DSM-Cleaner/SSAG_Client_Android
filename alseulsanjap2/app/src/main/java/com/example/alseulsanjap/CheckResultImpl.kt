package com.example.alseulsanjap

import com.example.alseulsanjap.util.ApiProvider
import retrofit2.Response

class CheckResultImpl: CheckResultRepository,SafeCallRequest() {
    override suspend fun getCleanWeekData(accessToken: String,studentId : Int): Response<CleanWeekResponse> {
        return safeApiCall { ApiProvider.getAPI().getCleanWeekData(accessToken,studentId) }
    }
}
package com.example.lokal.data.api

import com.example.lokal.data.model.JobData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("common/jobs")
    suspend fun getJobs(
        @Query("page") page: Int
    ): JobData
}
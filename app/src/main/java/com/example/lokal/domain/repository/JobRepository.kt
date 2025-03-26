package com.example.lokal.domain.repository

import com.example.lokal.data.model.JobData

interface JobRepository {
    suspend fun getJobs(page: Int): JobData
}
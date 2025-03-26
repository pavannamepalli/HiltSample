package com.example.lokal.data.repositoryImpl

import com.example.lokal.data.api.ApiService
import com.example.lokal.data.model.JobData
import com.example.lokal.domain.repository.JobRepository
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor(private val apiService: ApiService) : JobRepository {
    override suspend fun getJobs(page: Int): JobData {
        return apiService.getJobs(page) // Directly returning the API response
    }
}
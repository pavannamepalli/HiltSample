package com.example.lokal.domain.usecase

import com.example.lokal.data.model.JobData
import com.example.lokal.domain.repository.JobRepository
import javax.inject.Inject


class JobUseCase @Inject constructor(private val jobRepository: JobRepository) {
    suspend fun execute(page: Int): JobData {
        return jobRepository.getJobs(page) // Fetches data from the repository
    }
}
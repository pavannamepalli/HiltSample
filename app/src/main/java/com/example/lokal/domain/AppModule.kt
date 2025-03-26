package com.example.lokal.domain

import com.example.lokal.data.api.ApiService
import com.example.lokal.data.repositoryImpl.JobRepositoryImpl
import com.example.lokal.domain.repository.JobRepository
import com.example.lokal.domain.usecase.JobUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://testapi.getlokalapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideJobRepository(apiService: ApiService): JobRepository {
        return JobRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetJobsUseCase(jobRepository: JobRepository): JobUseCase {
        return JobUseCase(jobRepository)
    }
}
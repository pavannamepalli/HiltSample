package com.example.lokal.presentation.viewmodel

import androidx.annotation.IntDef
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokal.data.model.JobData
import com.example.lokal.domain.usecase.JobUseCase
import com.example.lokal.utilities.ResultClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobViewModel @Inject constructor(private val getJobsUseCase: JobUseCase) : ViewModel() {

    private val _jobsLiveData = MutableLiveData<ResultClass<JobData>>()
    val jobsLiveData: LiveData<ResultClass<JobData>> = _jobsLiveData

    fun fetchJobs(page: Int) {
        _jobsLiveData.value = ResultClass.Loading // Emit loading state

        viewModelScope.launch {
            try {
                val jobResponse = getJobsUseCase.execute(page)
                _jobsLiveData.value = ResultClass.Success(jobResponse) // Emit success state
            } catch (e: Exception) {
                _jobsLiveData.value = ResultClass.Error(e.localizedMessage ?: "Unknown Error") // Emit error state
            }
        }
    }
}
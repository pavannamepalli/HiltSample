package com.example.lokal.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.lokal.R
import com.example.lokal.data.api.RetrofitClient
import com.example.lokal.data.repositoryImpl.JobRepositoryImpl
import com.example.lokal.domain.usecase.JobUseCase
import com.example.lokal.presentation.viewmodel.JobViewModel
import com.example.lokal.utilities.ResultClass
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val jobViewModel: JobViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        jobViewModel.fetchJobs(1)
        jobViewModel.jobsLiveData.observe(this) { result ->
            when (result) {
                is ResultClass.Loading -> {

                }
                is ResultClass.Success -> {
                    Toast.makeText(this, result.data.results[0].title, Toast.LENGTH_SHORT).show()
                }
                is ResultClass.Error -> {

                }


            }
        }
    }
}
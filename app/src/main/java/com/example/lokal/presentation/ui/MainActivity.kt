package com.example.lokal.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lokal.R
import com.example.lokal.data.api.RetrofitClient
import com.example.lokal.data.repositoryImpl.JobRepositoryImpl
import com.example.lokal.domain.usecase.JobUseCase
import com.example.lokal.presentation.adapter.JobAdapter
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

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        jobViewModel.fetchJobs(1)
        jobViewModel.jobsLiveData.observe(this) { result ->
            when (result) {
                is ResultClass.Loading -> {

                }
                is ResultClass.Success -> {
                    val adapter = JobAdapter(result.data.results)
                    recyclerView.adapter = adapter

                }
                is ResultClass.Error -> {

                }


            }
        }
    }
}
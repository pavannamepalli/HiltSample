package com.example.lokal.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lokal.R

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lokal.data.model.Result

class JobAdapter(private val jobList: List<Result>) :
    RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.textTitle)
        val subtitle: TextView = view.findViewById(R.id.textSubtitle)
        val description: TextView = view.findViewById(R.id.textDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        holder.title.text = job.title
        holder.subtitle.text = job.amount
        holder.description.text = job.amount
    }

    override fun getItemCount() = jobList.size
}
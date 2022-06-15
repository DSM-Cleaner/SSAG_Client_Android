package com.example.alseulsanjap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.CleanCheckBoxBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeekCleanAdapter(private val viewModel: CheckResultViewModel) :
    RecyclerView.Adapter<WeekCleanAdapter.WeekCleanViewHolder>() {

    private var userProjectList = ArrayList<CleanWeekResponse>()

    inner class WeekCleanViewHolder(private val binding: CleanCheckBoxBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CleanWeekResponse, position: Int) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("MM월 dd일")
            val formatted = current.format(formatter)

            binding.shoesTv.text = item.results[position]!!.bedding.toString()
            binding.concentTv.text = item.results[position]!!.plug.toString()
            binding.vm = viewModel
            binding.notifyChange()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekCleanViewHolder {
        val binding = CleanCheckBoxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeekCleanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeekCleanViewHolder, position: Int) {
        holder.bind(userProjectList)
    }

    override fun getItemCount(): Int {
        return userProjectList.size
    }

    fun setItem(projects: ArrayList<CleanWeekResponse>) {
        this.userProjectList = projects
        notifyDataSetChanged()
    }
}
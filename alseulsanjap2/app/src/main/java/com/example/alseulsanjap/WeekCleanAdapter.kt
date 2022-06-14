package com.example.alseulsanjap

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.CleanCheckBoxBinding

class WeekCleanAdapter(private val viewModel: CheckResultViewModel) :
    RecyclerView.Adapter<WeekCleanAdapter.WeekCleanViewHolder>() {

    inner class WeekCleanViewHolder(private val binding: CleanCheckBoxBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CleanWeekResponse, position: Int) {
            binding.shoesTv.text = item.results[position]!!.bedding.toString()
            binding.concentTv.text = item.results[position]!!.plug.toString()
            binding.vm = viewModel
            binding.notifyChange()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekCleanViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: WeekCleanViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
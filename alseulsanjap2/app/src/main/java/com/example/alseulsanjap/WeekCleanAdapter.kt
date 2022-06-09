package com.example.alseulsanjap

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.CleanCheckBoxBinding

class WeekCleanAdapter(private val viewModel: CheckResultViewModel) : RecyclerView.Adapter<WeekCleanAdapter.>{

    inner class WeekCleanViewHolder(private val binding: CleanCheckBoxBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CleanWeekResponse, position: Int) {
            binding.textView22.text = "${item.results[]}"
            binding.vm = viewModel
            binding.notifyChange()
            binding.userProjectCv.setOnClickListener {
                viewModel.getProjectIdForPlan.value = item.planId
                prefs.savePlanId(item.planId,"planId")
                viewModel.planclickFinish.value = item
                viewModel.planItemContent.value = item.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ??? {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ???, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
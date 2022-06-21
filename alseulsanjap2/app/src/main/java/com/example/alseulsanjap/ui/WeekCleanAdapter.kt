package com.example.alseulsanjap.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alseulsanjap.CleanWeekResponse
import com.example.alseulsanjap.R
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.CleanCheckBoxBinding
import com.example.alseulsanjap.di.SsagApplication
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeekCleanAdapter(
    private val viewModel: CheckResultViewModel
) :
    RecyclerView.Adapter<WeekCleanAdapter.WeekCleanViewHolder>() {

    private var items = ArrayList<CleanWeekResponse.WeekDetail>()

    val list = ArrayList<Int>()
    private val green = SsagApplication.context.resources.getColor(R.color.color_green)
    private val red = SsagApplication.context.resources.getColor(R.color.red)

    inner class WeekCleanViewHolder(private val binding: CleanCheckBoxBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CleanWeekResponse.WeekDetail, position: Int) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("MM월 dd일")
            val formatted = current.format(formatter)

            binding.textView6.text = item.day

            if (item.bedding.equals(1)) {
                binding.frontTv.text = "통과"
                binding.frontTv.setTextColor(green)
            } else if (item.bedding.equals(0)) {
                binding.frontTv.text = "불통과"
                binding.frontTv.setTextColor(red)
                list.add(1)
            }

            if (item.clothes.equals(1)) {
                binding.personalTv.text = "통과"
                binding.personalTv.setTextColor(green)
            } else if (item.clothes.equals(0)) {
                binding.personalTv.text = "불통과"
                binding.personalTv.setTextColor(red)
                list.add(1)
            }


            if (item.light.equals(1)) {
                binding.lightTv.text = "통과"
                binding.lightTv.setTextColor(green)
            } else if (item.light.equals(0)) {
                binding.lightTv.text = "불통과"
                list.add(1)
                binding.lightTv.setTextColor(red)
            }


            if (item.plug.equals(1)) {
                binding.concentTv.text = "통과"
                binding.concentTv.setTextColor(green)
            } else if (item.plug.equals(0)) {
                binding.concentTv.text = "불통과"
                list.add(1)
                binding.concentTv.setTextColor(red)
            }


            if (item.shoes.equals(1)) {
                binding.shoesTv.text = "통과"
                binding.shoesTv.setTextColor(green)
            } else if (item.shoes.equals(0)) {
                binding.shoesTv.text = "불통과"
                list.add(1)
                binding.shoesTv.setTextColor(red)
            }


            if (item.personalplace.equals(1)) {
                binding.selfTv.text = "통과"
                binding.selfTv.setTextColor(green)
            } else if (item.personalplace.equals(0)) {
                binding.selfTv.text = "불통과"
                list.add(1)
                binding.selfTv.setTextColor(red)
            }



            Log.e(list.toString(), "countcount")
            if (list.size > 15) {
                viewModel.countWeek.value = "불량"
            } else
                viewModel.countWeek.value = "양호"

            Log.e(viewModel.countWeek.value, "과연 어떻게")


            binding.vm = viewModel
            binding.notifyChange()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekCleanViewHolder {
        val binding =
            CleanCheckBoxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeekCleanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeekCleanViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItem(item: ArrayList<CleanWeekResponse.WeekDetail>) {
        this.items = item
        notifyDataSetChanged()
    }

}
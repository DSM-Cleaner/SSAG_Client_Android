package com.example.alseulsanjap

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.ActivityCertificationBinding.bind
import com.example.alseulsanjap.databinding.CleanCheckBoxBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WeekCleanAdapter(
    private val viewModel: CheckResultViewModel
) :
    RecyclerView.Adapter<WeekCleanAdapter.WeekCleanViewHolder>() {

    private var items = ArrayList<CleanWeekResponse.WeekDetail>()

    val list = ArrayList<Int>()

    inner class WeekCleanViewHolder(private val binding: CleanCheckBoxBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CleanWeekResponse.WeekDetail, position: Int) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("MM월 dd일")
            val formatted = current.format(formatter)

            binding.textView6.text = item.day

            if (item.bedding.equals(1)) {
                binding.frontTv.text = "통과"
            } else
                binding.frontTv.text = "불통과"
                list.add(1)


            if(item.clothes.equals(1)){
                binding.personalTv.text = "통과"
            }
            else
                binding.personalTv.text = "불통과"
                list.add(1)

            if(item.light.equals(1)){
                binding.lightTv.text ="통과"
            }
            else
                binding.lightTv.text = "불통과"
                list.add(1)

            if(item.plug.equals(1)){
                binding.concentTv.text ="통과"
            }
            else
                binding.concentTv.text = "불통과"
                list.add(1)

            if(item.shoes.equals(1)){
                binding.shoesTv.text ="통과"
            }
            else
                binding.shoesTv.text = "불통과"
                list.add(1)

            if(item.personalplace.equals(1)){
                binding.selfTv.text ="통과"
            }
            else
                binding.selfTv.text = "불통과"
                list.add(1)


            Log.e(list.toString(),"countcount")
            if(list.size > 15){
               viewModel.countWeek.value = "불량"
            }
            else
                viewModel.countWeek.value = "양호"

            Log.e(viewModel.countWeek.value,"과연 어떻게")


            binding.vm = viewModel
            binding.notifyChange()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekCleanViewHolder {
        val binding = CleanCheckBoxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeekCleanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeekCleanViewHolder, position: Int) {
        holder.bind(items[position],position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItem(item: ArrayList<CleanWeekResponse.WeekDetail>) {
        this.items = item
        notifyDataSetChanged()
    }

}
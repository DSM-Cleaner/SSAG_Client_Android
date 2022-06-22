package com.example.alseulsanjap.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.alseulsanjap.BaseActivity
import com.example.alseulsanjap.R
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.ActivityCheckResultBinding
import com.example.alseulsanjap.di.SsagApplication.Companion.context
import org.koin.androidx.viewmodel.ext.android.viewModel


class CheckResultActivity : BaseActivity<ActivityCheckResultBinding>(R.layout.activity_check_result) {

    override val vm: CheckResultViewModel by viewModel()
    private val weekCleanAdapter by lazy { WeekCleanAdapter(vm) }

    private val green = context.resources.getColor(R.color.color_green)
    private val red = context.resources.getColor(R.color.red)
    private val black = context.resources.getColor(R.color.black)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.getCleanInfo()
        successGetData()
        showRV()
        weekCleanCheck()

    }

    private fun showRV(){
        binding.viewPager2.adapter = weekCleanAdapter
        binding.notifyChange()
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        vm.getDataInfo.observe(this,{
            weekCleanAdapter.setItem(it.results)
        })
        //val dotsIndicator = binding.dotsIndicator
//        TabLayoutMediator(dotsIndicator, binding.viewPager2) { _, _ ->
//        }.attach()
    }

    fun weekCleanCheck(){
        vm.countWeek.observe(this,{
            Log.e(vm.countWeek.value!!,"청소를 어따구로 하는거")

            if(vm.countWeek.value == "양호"){
                binding.countWeek.text = vm.countWeek.value
                binding.countWeek.setTextColor(green)
            }
            else if(vm.countWeek.value.equals("불량")){
                binding.countWeek.text = vm.countWeek.value
                binding.countWeek.setTextColor(red)
            }
            else
                binding.countWeek.text = vm.countWeek.value
        })
    }


    fun successGetData() {
        vm.getUserName.observe(this,{
            binding.name = vm.getUserName.value!!
            binding.number = vm.getDataInfo.value!!.gcn.toString()
            val result =vm.getDataInfo.value!!.roomId.toString() + "호 " + vm.getDataInfo.value!!.bed
            Log.e(result,"결과 결과 결과")
            binding.nameNumber = result
        })
    }
}
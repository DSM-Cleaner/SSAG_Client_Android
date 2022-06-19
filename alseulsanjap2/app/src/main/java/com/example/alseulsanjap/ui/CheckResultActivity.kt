package com.example.alseulsanjap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.example.alseulsanjap.BaseActivity
import com.example.alseulsanjap.R
import com.example.alseulsanjap.WeekCleanAdapter
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.ActivityCheckResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckResultActivity : BaseActivity<ActivityCheckResultBinding>(R.layout.activity_check_result) {

    override val vm: CheckResultViewModel by viewModel()
    private val weekCleanAdapter by lazy { WeekCleanAdapter(vm) }

    private val MIN_SCALE = 0.85f // 뷰가 몇퍼센트로 줄어들 것인지
    private val MIN_ALPHA = 0.5f // 어두워지는 정도를 나타낸 듯 하다

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.getCleanInfo()
        successGetData()
        showRV()

//        binding.viewPager2.adapter =
//            binding.viewager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        binding.viewPager2.setPageTransformer(ZoomOutPageTransformer())
//        binding.number = vm.studentId.value.toString()
        //binding.textView8.text = vm.studentId.value.toString()
    }

    private fun showRV(){
        binding.viewPager2.adapter = weekCleanAdapter
        binding.notifyChange()

        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }


    fun successGetData() {
        vm.getUserName.observe(this,{
            binding.name = vm.getUserName.value!!
            binding.number = vm.getDataInfo.value!!.gcn.toString()
            binding.nameNumber = vm.getDataInfo.value!!.roomId.toString() + "호 " + vm.getDataInfo.value!!.bed
        })
    }


    inner class ZoomOutPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                val pageHeight = height
                when {
                    position < -1 -> { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        alpha = 0f
                    }
                    position <= 1 -> { // [-1,1]
                        // Modify the default slide transition to shrink the page as well
                        val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                        val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        val horzMargin = pageWidth * (1 - scaleFactor) / 2
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2
                        } else {
                            horzMargin + vertMargin / 2
                        }

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scaleFactor
                        scaleY = scaleFactor

                        // Fade the page relative to its size.
                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                    }
                    else -> { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        alpha = 0f
                    }
                }
            }
        }
    }

}
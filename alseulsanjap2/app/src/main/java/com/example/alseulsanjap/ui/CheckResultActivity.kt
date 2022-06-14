package com.example.alseulsanjap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.alseulsanjap.BaseActivity
import com.example.alseulsanjap.R
import com.example.alseulsanjap.checkresult.CheckResultViewModel
import com.example.alseulsanjap.databinding.ActivityCheckResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckResultActivity : BaseActivity<ActivityCheckResultBinding>(R.layout.activity_check_result) {

    override val vm: CheckResultViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm.getCleanInfo()

    }
}
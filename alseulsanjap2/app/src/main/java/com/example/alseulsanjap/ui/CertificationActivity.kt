package com.example.alseulsanjap.ui

import android.content.Intent
import android.os.Bundle
import com.example.alseulsanjap.BaseActivity
import com.example.alseulsanjap.R
import com.example.alseulsanjap.certification.CertificationViewModel
import com.example.alseulsanjap.databinding.ActivityCertificationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CertificationActivity :
    BaseActivity<ActivityCertificationBinding>(R.layout.activity_certification) {

    override val vm: CertificationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        successCertification()
    }

    private fun successCertification(){
        if(vm.successCertification.value == true){
            val intent = Intent(this,CheckResultActivity::class.java)
            startActivity(intent)
        }
    }
}
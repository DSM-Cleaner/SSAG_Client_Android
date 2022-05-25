package com.example.alseulsanjap.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        failCertification()
    }

    private fun successCertification(){
        if(vm.successCertification.value == true){
            Toast.makeText(this,vm.toastMessage.value!!,Toast.LENGTH_SHORT).show()
            Log.e("asdfasdf","sdfsdfa")
        }
    }

    private fun failCertification(){
        if(vm.failCertification.value == false){
            binding.textView5.visibility
        }
    }
}
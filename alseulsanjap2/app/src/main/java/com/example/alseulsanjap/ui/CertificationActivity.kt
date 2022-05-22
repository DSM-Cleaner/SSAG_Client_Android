package com.example.alseulsanjap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.alseulsanjap.CertificationViewModel
import com.example.alseulsanjap.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class CertificationActivity : AppCompatActivity() {

    private val certificationViewModel: CertificationViewModel by viewModel()

    val successfragment = SuccessFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certification)

        suceessLogin()
    }

    fun suceessLogin() {
        certificationViewModel.run {
            if (successCertification.value == true) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.success_container, successfragment)
                    .commit()

                //visible
                val visible : TextView = findViewById(R.id.textView5)
                visible.visibility
            }
            toastMessage.observe(this@CertificationActivity, {
                //토스트 띄워주기
                Toast.makeText(this@CertificationActivity, it, Toast.LENGTH_SHORT).show()
            })
        }
    }
}
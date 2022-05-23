package com.example.alseulsanjap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.alseulsanjap.certification.CertificationViewModel
import com.example.alseulsanjap.R
import com.example.alseulsanjap.databinding.ActivityCertificationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CertificationActivity : AppCompatActivity() {

    private val certificationViewModel: CertificationViewModel by viewModel()
    private lateinit var binding: ActivityCertificationBinding
    val successfragment = SuccessFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certification)

        suceessLogin()
        onClickLogin()
    }

    private fun onClickLogin(){
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){
           certificationViewModel.checkCertificationCode()
        }
    }

    fun suceessLogin() {
        certificationViewModel.run {
            if (successCertification.value == true) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.success_container, successfragment)
                    .commit()

                val visible: TextView = findViewById(R.id.textView5)
                visible.visibility
            }
            toastMessage.observe(this@CertificationActivity, {
                Toast.makeText(this@CertificationActivity, it, Toast.LENGTH_SHORT).show()
            })
        }
    }
}
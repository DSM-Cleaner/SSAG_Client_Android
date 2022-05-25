package com.example.alseulsanjap.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
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

    fun showFragment() {
        val successFragment = SuccessFragment()
        //supportFragmentManager.beginTransaction().replace(R.id.certification_container,successFragment)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.certification_container, successFragment)
        transaction.commit()

        intentActivity()

    }

    private fun intentActivity() {
        run {
            Handler().postDelayed({
                val intent = Intent(this, CheckResultActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }, DURATION)
        }
    }

    companion object {
        private const val DURATION: Long = 2500
    }




    private fun successCertification() {
        vm.doneLogin.observe(this, {
            if (vm.doneLogin.value == true) {
                showFragment()
            }
        }
        )

    }

    private fun failCertification() {
        if (vm.failCertification.value == false) {
            binding.textView5.visibility
        }
    }
}
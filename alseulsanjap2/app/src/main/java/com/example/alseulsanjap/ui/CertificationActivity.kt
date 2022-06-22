package com.example.alseulsanjap.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
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
        //vm.autoLogin()
    }

    fun showFragment() {
        val successFragment = SuccessFragment()
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
                binding.isLoading = true
                showFragment()
            }
        }
        )
    }

    private fun failCertification() {
        vm.failCertification.observe(this,{
            if (vm.failCertification.value == true) {
                binding.wrong = "인증번호가 틀렸습니다."
            }
        })
    }
}
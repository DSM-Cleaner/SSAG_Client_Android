package com.example.alseulsanjap

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.math.log

class CertificationViewModel : ViewModel() {

    private val prefs = SharedPreferenceStorage(SsagApplication.context)

    private val certificationRespository = CertificationImpl()
    private val _certificationCode: MutableLiveData<CertificationRequest> = MutableLiveData()
    private val _response : MutableLiveData<CertificationResponse> = MutableLiveData()
    private val _successCertification: MutableLiveData<Boolean> = MutableLiveData(false)

    val certificationCode = _certificationCode
    val response = _response
    val successCertification = _successCertification

    val userCode = MutableLiveData<String>()
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    fun checkCertificationCode() {
        viewModelScope.launch {
            val response = certificationRespository.doCertification(CertificationRequest(userCode.value!!))
            if (response.isSuccessful) {
                    //유저 아이디 저장
                     Log.e("postrequest",userCode.value!!)
                     Log.e("response",response.body()!!.id)

                    _successCertification.value == true

                    prefs.saveInfo(response.body()!!.authorization,"authorization")
                    prefs.saveInfo(response.body()!!.id,"id")

                    //_toastMessage.value = "인증에 성공하였습니다."
                    // 성공시 intent
                    //_successCertification.value == true
            }
        }
    }
}
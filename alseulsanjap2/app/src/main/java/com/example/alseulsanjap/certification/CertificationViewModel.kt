package com.example.alseulsanjap.certification

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alseulsanjap.CertificationImpl
import com.example.alseulsanjap.CertificationRequest
import com.example.alseulsanjap.CertificationResponse
import com.example.alseulsanjap.SharedPreferenceStorage
import com.example.alseulsanjap.di.SsagApplication
import kotlinx.coroutines.launch

class CertificationViewModel : ViewModel() {

    private val prefs = SharedPreferenceStorage(SsagApplication.context)

    private val certificationRespository = CertificationImpl()
    private val _certificationCode: MutableLiveData<CertificationRequest> = MutableLiveData()
    private val _response : MutableLiveData<CertificationResponse> = MutableLiveData()
    private val _successCertification: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _failCertification : MutableLiveData<Boolean> = MutableLiveData(true)

    val certificationCode = _certificationCode
    val response = _response
    val successCertification = _successCertification
    val failCertification = _failCertification

    private val _doneLogin = MutableLiveData(false)
    val doneLogin: LiveData<Boolean> get() = _doneLogin

    private val _successAddProject = MutableLiveData<Boolean>()
    val successAddProject: LiveData<Boolean> get() = _successAddProject

    val userCode = MutableLiveData<String>()
    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

//    fun textWatcher() {
//        editText.addTextChangedListener(object : TextWatcher {
//            // text watcher methods will be called when the text is changed
//            override fun beforeTextChanged(
//                p0: CharSequence?,
//                p1: Int, p2: Int, p3: Int
//            ) {
//                // do something before text changed
//            }
//
//            override fun onTextChanged(
//                p0: CharSequence?,
//                p1: Int, p2: Int, p3: Int
//            ) {
//                // do something on text changed
//                textView.text = "On text changed\n\n$p0"
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                // do something after text changed
//            }
//        }
//    }
    fun checkCertificationCode() {
        viewModelScope.launch {
            val response =
                certificationRespository.doCertification(CertificationRequest(userCode.value!!))
            if (response.isSuccessful) {
                if (response.code() == 200) {
                    _toastMessage.value = "인증에 성공하였습니다."

                    _doneLogin.value = true
                    prefs.saveInfo(response.body()!!.authorization, "authorization")
                    prefs.saveInfo(response.body()!!.id, "id")
                }
            }
            else
                _failCertification.value = false

        }
    }
}
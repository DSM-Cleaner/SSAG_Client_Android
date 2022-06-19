package com.example.alseulsanjap.checkresult

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alseulsanjap.CheckResultImpl
import com.example.alseulsanjap.CheckResultRequest
import com.example.alseulsanjap.CleanWeekResponse
import com.example.alseulsanjap.SharedPreferenceStorage
import com.example.alseulsanjap.di.SsagApplication
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*

class CheckResultViewModel : ViewModel() {

    private val prefs = SharedPreferenceStorage(SsagApplication.context)

    private val checkRepository = CheckResultImpl()

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    private val _nowDate = MutableLiveData<String>()
    val nowDate : LiveData<String> get() = _nowDate

    private val _bedding = MutableLiveData<Int>()
    val bedding : LiveData<Int> get() = _bedding

    private val _clothes = MutableLiveData<Int>()
    val clothes : LiveData<Int> get() = _clothes

    private val _studentId = MutableLiveData<Int>()
    val studentId : LiveData<Int> get() = _studentId

    private val _studentName = MutableLiveData<String>()
    val studentName : LiveData<String> get() = _studentName

    private val _doneGetInfo = MutableLiveData(false)
    val doneGetInfo: LiveData<Boolean> get() = _doneGetInfo

    private val _getDataInfo: MutableLiveData<CleanWeekResponse> = MutableLiveData()
    val getDataInfo  = _getDataInfo

    private val _getDetailDataInfo: MutableLiveData<CleanWeekResponse.WeekDetail> = MutableLiveData()
    val getDetailDataInfo  = _getDetailDataInfo

    private val _getUserName : MutableLiveData<String> = MutableLiveData()
    val getUserName = _getUserName

    private var userName : String = ""


    fun getCleanInfo() {
        viewModelScope.launch {
            val studentId = prefs.getInfo("id")
            val studentIntId: Int = studentId.toInt()

            val response =
                checkRepository.getCleanWeekData(prefs.getInfo("authorization"), studentIntId)

            if (response.isSuccessful) {
                if (response.code() == 200) {
                    _doneGetInfo.value = true
                    _getDataInfo.postValue(response.body())
                    _getUserName.postValue(response.body()!!.name)

                    //날짜 가지고 오기
                    val onlyDate: LocalDate = LocalDate.now()
                    println("Current date: $onlyDate")
                    _nowDate.value = onlyDate.toString()

                }
                else
                    _toastMessage.value = "데이터 로드에 실패하였습니다"
            } else
                _toastMessage.value = "데이터 로드에 실패하였습니다"
        }

        fun checkWeekCleanRoom() {
            viewModelScope.launch {

            }
        }
    }

}
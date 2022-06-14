package com.example.alseulsanjap.checkresult

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alseulsanjap.CheckResultImpl
import com.example.alseulsanjap.CheckResultRequest
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


    fun getCleanInfo(){
        viewModelScope.launch {
            Log.e(prefs.getInt("id",0),"1111122222")

            //val response = checkRepository.getCleanWeekData(prefs.getInfo("authorization"),studentId)

//            if(response.isSuccessful){
//                if(response.code() == 200){
//                    Log.e(response.body()!!.bed,"success")

                    //이번주의 청소 점검 상태 확인하기
//                     _bedding.value = response.body()!!.results[].bedding
//                     if(_bedding.value == 0){
                         //0이면 통과
                   //  }
//                    else
                        //1이면 불통과

                    //_clothes.value = response






                    //날짜 가지고 오기
                    val onlyDate: LocalDate = LocalDate.now()
                    println("Current date: $onlyDate")
                    _nowDate.value = onlyDate.toString()

                }
//            }
//            else
//                _toastMessage.value = "데이터 로드에 실패하였습니다"
//        }
    }

    fun checkWeekCleanRoom(){
        viewModelScope.launch {

        }
    }


}
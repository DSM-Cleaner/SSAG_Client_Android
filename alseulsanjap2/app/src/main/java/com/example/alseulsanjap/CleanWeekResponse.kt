package com.example.alseulsanjap

data class CleanWeekResponse(
    val name : String,
    val gcn: Int,
    val roomId : Int,
    val bed : String,
    val results : ArrayList<WeekDetail>
){
    data class WeekDetail(
        val day : String,
        val light : Int,
        val plug : Int,
        val shoes : Int,
        val bedding : Int,
        val clothes : Int,
        val personalplace : Boolean
    )
}

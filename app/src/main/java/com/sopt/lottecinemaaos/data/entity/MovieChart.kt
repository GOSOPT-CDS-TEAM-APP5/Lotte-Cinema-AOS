package com.sopt.lottecinemaaos.data.entity

data class MovieChart(
    val viewType:Int,
    val title:String?,
    val reservationRate: Double?,
    val release:Boolean?,
    val startRate:Int?,
    val day:Int?
)

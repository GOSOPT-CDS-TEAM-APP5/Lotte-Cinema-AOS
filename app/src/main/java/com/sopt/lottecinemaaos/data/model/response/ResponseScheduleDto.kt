package com.sopt.lottecinemaaos.data.model.response

import com.sopt.lottecinemaaos.data.entity.Schedule
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseScheduleDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Schedule>

)

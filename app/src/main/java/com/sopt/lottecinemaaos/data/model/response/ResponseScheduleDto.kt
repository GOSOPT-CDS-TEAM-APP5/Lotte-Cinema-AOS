package com.sopt.lottecinemaaos.data.model.response

import com.sopt.lottecinemaaos.data.entity.MultiplexList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseScheduleDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Cinema>
) {
    @Serializable
    data class Cinema(
        @SerialName("theaterName")
        val theaterName: String,
        @SerialName("multiplexList")
        val multiplexList: List<MultiplexList>
    )
}
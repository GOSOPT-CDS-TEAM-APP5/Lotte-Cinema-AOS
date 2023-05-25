package com.sopt.lottecinemaaos.data.model.response

import com.sopt.lottecinemaaos.data.entity.Theater
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTheaterDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Theater>
)

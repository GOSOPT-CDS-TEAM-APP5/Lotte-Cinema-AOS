package com.sopt.lottecinemaaos.data.model.response

import com.sopt.lottecinemaaos.data.entity.Region
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseRegionDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Region>

)

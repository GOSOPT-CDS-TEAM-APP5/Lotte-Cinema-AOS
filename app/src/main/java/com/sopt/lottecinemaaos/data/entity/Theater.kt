package com.sopt.lottecinemaaos.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Theater(
    @SerialName("theater_id")
    val theaterId: Int,
    @SerialName("theater_name")
    val theaterName: String
)

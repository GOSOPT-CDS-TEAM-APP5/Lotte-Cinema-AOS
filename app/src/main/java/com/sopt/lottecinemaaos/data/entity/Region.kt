package com.sopt.lottecinemaaos.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Region(
    @SerialName("region_id")
    val regionId: Int,
    @SerialName("region_name")
    val regionName: String,
    @SerialName("theater_count")
    val theaterCount: Int

)

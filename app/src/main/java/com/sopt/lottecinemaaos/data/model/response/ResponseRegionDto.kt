package com.sopt.lottecinemaaos.data.model.response

import com.sopt.lottecinemaaos.domain.model.Region
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
) {
    @Serializable
    data class Region(
        @SerialName("region_id")
        val regionId: Int,
        @SerialName("region_name")
        val regionName: String,
        @SerialName("theater_count")
        val theaterCount: Int
    )

    fun toRegion() = data.map { region ->
        Region(
            id = region.regionId,
            name = region.regionName,
            count = region.theaterCount
        )
    }
}

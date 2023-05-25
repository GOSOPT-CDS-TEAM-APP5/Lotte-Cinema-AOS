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
    val data: List<RegionData>
) {
    @Serializable
    data class RegionData(
        @SerialName("regionId")
        val regionId: Int,
        @SerialName("regionName")
        val regionName: String,
        @SerialName("theaterCount")
        val theaterCount: Int
    )

    fun toRegion() = data.map { region ->
        Region(
            regionId = region.regionId,
            regionName = region.regionName,
            theaterCount = region.theaterCount
        )
    }
}

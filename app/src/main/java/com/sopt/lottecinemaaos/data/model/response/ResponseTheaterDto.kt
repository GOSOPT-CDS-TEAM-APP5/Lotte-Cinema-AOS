package com.sopt.lottecinemaaos.data.model.response

import com.sopt.lottecinemaaos.domain.model.Theater
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
) {
    @Serializable
    data class Theater(
        @SerialName("theaterId")
        val theaterId: Int,
        @SerialName("theaterName")
        val theaterName: String
    )

    fun toTheater() = data.map { theater ->
        Theater(
            id = theater.theaterId,
            name = theater.theaterName
        )
    }
}

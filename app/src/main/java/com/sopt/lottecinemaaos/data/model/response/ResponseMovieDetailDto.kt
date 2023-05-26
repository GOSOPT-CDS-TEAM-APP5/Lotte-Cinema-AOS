package com.sopt.lottecinemaaos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMovieDetailDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: MovieDetailData,
) {
    @Serializable
    data class MovieDetailData(
        @SerialName("movieName")
        val movieName: String,
        @SerialName("reservationRatio")
        val reservationRatio: Double,
        @SerialName("scoreOfStar")
        val scoreOfStar: Double,
        @SerialName("age")
        val age: Int,
        @SerialName("releaseDate")
        val releaseDate: Int,
        @SerialName("genre")
        val genre: String,
        @SerialName("playFullTime")
        val playFullTime: Int,
        @SerialName("synopsis")
        val synopsis: String,
    )
}

package com.sopt.lottecinemaaos.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseHomeMovieChartDto(
    @SerialName("age")
    val age: Int,
    @SerialName("artte")
    val artte: Boolean,
    @SerialName("genre")
    val genre: String,
    @SerialName("movieId")
    val movieId: Int,
    @SerialName("movieName")
    val movieName: String,
    @SerialName("playFullTime")
    val playFullTime: Int,
    @SerialName("release")
    val release: Boolean,
    @SerialName("releaseDate")
    val releaseDate: Int,
    @SerialName("reservationRatio")
    val reservationRatio: Double,
    @SerialName("scoreOfStar")
    val scoreOfStar: Double,
    @SerialName("synopsis")
    val synopsis: String
)
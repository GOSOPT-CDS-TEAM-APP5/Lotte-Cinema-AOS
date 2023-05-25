package com.sopt.lottecinemaaos.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Schedule(
    @SerialName("theater_name")
    val theaterName: String,
    @SerialName("multiplex_list")
    val multiplexList: List<MultiplexList>
) {
    @Serializable
    data class MultiplexList(
        @SerialName("multiplex_location")
        val multiplexLocation: String,
        @SerialName("schedule_list")
        val scheduleList: List<ScheduleList>
    ) {
        @Serializable
        data class ScheduleList(
            @SerialName("start_time")
            val startTime: String,
            @SerialName("end_time")
            val endTime: String,
            @SerialName("current_people")
            val currentPeople: String,
            @SerialName("max_people")
            val maxPeople: String
        )
    }
}

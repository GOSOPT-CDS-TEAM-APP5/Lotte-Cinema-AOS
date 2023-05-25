package com.sopt.lottecinemaaos.data.model.response

import com.sopt.lottecinemaaos.domain.model.TimeTable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseScheduleDto(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: List<Cinema>
) {
    @Serializable
    data class Cinema(
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

            fun toSchedule() = scheduleList.map { schedule ->
                TimeTable(
                    schedule.startTime,
                    schedule.endTime,
                    schedule.currentPeople,
                    schedule.maxPeople
                )
            }
        }
    }
}

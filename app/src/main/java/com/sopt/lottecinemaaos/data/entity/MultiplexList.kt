package com.sopt.lottecinemaaos.data.entity

import com.sopt.lottecinemaaos.domain.model.TimeTable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultiplexList(
    @SerialName("movieType")
    val movieType: String,
    @SerialName("multiplexLocation")
    val multiplexLocation: String,
    @SerialName("scheduleList")
    val scheduleList: List<ScheduleList>
) {
    @Serializable
    data class ScheduleList(
        @SerialName("startTime")
        val startTime: String,
        @SerialName("endTime")
        val endTime: String,
        @SerialName("currentPeople")
        val currentPeople: String,
        @SerialName("maxPeople")
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

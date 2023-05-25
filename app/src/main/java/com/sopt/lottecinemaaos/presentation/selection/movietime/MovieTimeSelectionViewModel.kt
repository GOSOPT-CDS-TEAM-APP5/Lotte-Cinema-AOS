package com.sopt.lottecinemaaos.presentation.selection.movietime

import androidx.lifecycle.ViewModel
import com.sopt.lottecinemaaos.data.entity.Calendar
import com.sopt.lottecinemaaos.domain.model.Theater
import com.sopt.lottecinemaaos.domain.model.TimeTable

class MovieTimeSelectionViewModel : ViewModel() {
    val cinemaList: List<Theater> =
        listOf(
            Theater(1, "홍대입구"),
            Theater(2, "브로드웨이(신사)"),
            Theater(3, "서울대입구"),
            Theater(4, "경기")

        )

    val dateList: List<Calendar> =
        listOf(
            Calendar(1, 7, "일"),
            Calendar(2, 8, "오늘"),
            Calendar(3, 9, "화"),
            Calendar(4, 10, "수"),
            Calendar(5, 11, "목"),
            Calendar(6, 12, "금"),
            Calendar(7, 13, "토"),
            Calendar(8, 14, "일")

        )

    val timeList: List<TimeTable> =
        listOf(
            TimeTable("13:00", "14:00", "130", "150"),
            TimeTable("12:00", "15:00", "134", "150"),
            TimeTable("15:00", "20:00", "112", "150"),
            TimeTable("13:00", "14:00", "130", "150"),
            TimeTable("12:00", "15:00", "134", "150"),
            TimeTable("15:00", "20:00", "112", "150"),
            TimeTable("13:00", "14:00", "130", "150"),
            TimeTable("12:00", "15:00", "134", "150"),
            TimeTable("15:00", "20:00", "112", "150")
        )
}

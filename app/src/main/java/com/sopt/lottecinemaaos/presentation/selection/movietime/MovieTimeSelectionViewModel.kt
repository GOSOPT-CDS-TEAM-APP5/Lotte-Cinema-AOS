package com.sopt.lottecinemaaos.presentation.selection.movietime

import androidx.lifecycle.ViewModel
import com.sopt.lottecinemaaos.data.entity.Calendar
import com.sopt.lottecinemaaos.data.entity.Cinema

class MovieTimeSelectionViewModel : ViewModel() {
    val cinemaList: List<Cinema> =
        listOf(
            Cinema(1, "홍대입구"),
            Cinema(2, "브로드웨이(신사)"),
            Cinema(3, "서울대입구"),
            Cinema(4, "경기")

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
}

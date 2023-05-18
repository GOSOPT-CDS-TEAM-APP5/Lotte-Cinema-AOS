package com.sopt.lottecinemaaos.presentation.selection

import androidx.lifecycle.ViewModel
import com.sopt.lottecinemaaos.data.entity.Region

class CinemaSelectionViewModel : ViewModel() {
    val regionList: List<Region> =
        listOf(
            Region(1, "MY 영화관", 0),
            Region(2, "가까운 영화관", 1),
            Region(3, "서울", 2),
            Region(4, "경기", 3),
            Region(5, "인천", 4),
            Region(6, "충청", 5),
            Region(7, "전라", 6),
            Region(8, "경북", 7),
            Region(9, "대구", 8),
            Region(10, "경남", 9)

        )
}

package com.sopt.lottecinemaaos.presentation.selection.movietime

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.lottecinemaaos.data.entity.Calendar
import com.sopt.lottecinemaaos.data.model.response.ResponseScheduleDto
import com.sopt.lottecinemaaos.data.repository.MovieSelectionRepositoryImpl
import com.sopt.lottecinemaaos.domain.model.Theater
import kotlinx.coroutines.launch

class MovieTimeSelectionViewModel(private val movieSelectionRepositoryImpl: MovieSelectionRepositoryImpl) :
    ViewModel() {
    init {
        getFirstTimeTableData()
    }

    private var _timeTableData: MutableLiveData<List<ResponseScheduleDto.Cinema>> =
        MutableLiveData()
    val timeTableData: LiveData<List<ResponseScheduleDto.Cinema>>
        get() = _timeTableData

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
            Calendar(8, 14, "일"),
            Calendar(9, 15, "월"),
            Calendar(10, 16, "화")

        )

    // 현재 더미데이터에 있는 movieId(가오갤)은 1이며, 영화관 ID값 홍대입구는 13, 브로드웨이는 9, 서울대입구는 10입니다!)
    private fun getFirstTimeTableData() {
        viewModelScope.launch {
            movieSelectionRepositoryImpl.getMovieSchedule("2023-05-08", 1, 13)
                .onSuccess { response ->
                    Log.d("timeSelection", "getTimeTableData 성공")
                    _timeTableData.value = response
                    Log.d("timeSelection", _timeTableData.value.toString())
                }.onFailure { error ->
                    Log.d("timeSelection", "getTimeTableData 실패: ${error.message}")
                }
        }
    }
}

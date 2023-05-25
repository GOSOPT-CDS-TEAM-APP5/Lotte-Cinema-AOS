package com.sopt.lottecinemaaos.domain.repository

import com.sopt.lottecinemaaos.data.model.response.ResponseScheduleDto
import com.sopt.lottecinemaaos.domain.model.Region
import com.sopt.lottecinemaaos.domain.model.Theater

interface MovieSelectionRepository {
    suspend fun getRegionList(): Result<List<Region>>
    suspend fun getTheaterList(id: Int): Result<List<Theater>>
    suspend fun getMovieSchedule(
        date: String,
        movieId: Int,
        theaterId: Int
    ): Result<List<ResponseScheduleDto.Cinema>>
}

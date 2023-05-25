package com.sopt.lottecinemaaos.data.datasource.remote

import com.sopt.lottecinemaaos.data.model.response.ResponseRegionDto
import com.sopt.lottecinemaaos.data.model.response.ResponseScheduleDto
import com.sopt.lottecinemaaos.data.model.response.ResponseTheaterDto
import com.sopt.lottecinemaaos.data.service.MovieSelectionService

class MovieSelectionRemoteDataSource(private val selectionService: MovieSelectionService) {
    suspend fun getAllRegion(): ResponseRegionDto = selectionService.getRegionList()
    suspend fun getTheaterLocation(regionId: Int): ResponseTheaterDto =
        selectionService.getTheaterList(regionId)

    suspend fun getMovieSchedule(date: String, movieId: Int, theaterId: Int): ResponseScheduleDto =
        selectionService.getScheduleList(date, movieId, theaterId)
}

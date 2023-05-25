package com.sopt.lottecinemaaos.data.datasource.remote

import com.sopt.lottecinemaaos.data.model.ServicePool
import com.sopt.lottecinemaaos.data.model.response.ResponseRegionDto
import com.sopt.lottecinemaaos.data.model.response.ResponseScheduleDto
import com.sopt.lottecinemaaos.data.model.response.ResponseTheaterDto

class MovieSelectionRemoteDataSource {
    private val selectionService = ServicePool.selectionService
    suspend fun getAllRegion(): ResponseRegionDto = selectionService.getRegionList()
    suspend fun getTheaterLocation(regionId: Int): ResponseTheaterDto =
        selectionService.getTheaterList(regionId)

    suspend fun getMovieSchedule(date: String, movieId: Int, theaterId: Int): ResponseScheduleDto =
        selectionService.getScheduleList(date, movieId, theaterId)
}

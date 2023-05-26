package com.sopt.lottecinemaaos.data.service

import com.sopt.lottecinemaaos.data.model.response.ResponseRegionDto
import com.sopt.lottecinemaaos.data.model.response.ResponseScheduleDto
import com.sopt.lottecinemaaos.data.model.response.ResponseTheaterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieSelectionService {
    @GET("/region")
    suspend fun getRegionList(): ResponseRegionDto

    @GET("/theater")
    suspend fun getTheaterList(
        @Query("regionId") id: Int
    ): ResponseTheaterDto

    @GET("/schedule")
    suspend fun getScheduleList(
        @Query("date") date: String,
        @Query("movieId") movieId: Int,
        @Query("theaterId") theaterId: Int
    ): ResponseScheduleDto
}
package com.sopt.lottecinemaaos.data.repository

import android.util.Log
import com.sopt.lottecinemaaos.data.datasource.remote.MovieSelectionRemoteDataSource
import com.sopt.lottecinemaaos.data.model.response.ResponseScheduleDto
import com.sopt.lottecinemaaos.domain.model.Region
import com.sopt.lottecinemaaos.domain.model.Theater
import com.sopt.lottecinemaaos.domain.repository.MovieSelectionRepository

class MovieSelectionRepositoryImpl(private val selectionDataSource: MovieSelectionRemoteDataSource) :
    MovieSelectionRepository {
    override suspend fun getRegionList(): Result<List<Region>> =
        runCatching {
            selectionDataSource.getAllRegion().toRegion()
        }.onSuccess {
            Log.d("region", "region get 성공")
        }.onFailure {
            Log.d("region", "region get 실패..")
        }

    override suspend fun getTheaterList(id: Int): Result<List<Theater>> =
        runCatching {
            selectionDataSource.getTheaterLocation(id).toTheater()
        }.onSuccess {
            Log.d("theater", "theater get 성공")
        }.onFailure {
            Log.d("theater", "theater get 실패..")
        }

    override suspend fun getMovieSchedule(
        date: String,
        movieId: Int,
        theaterId: Int
    ): Result<List<ResponseScheduleDto.Cinema>> =
        runCatching {
            selectionDataSource.getMovieSchedule(
                date,
                movieId,
                theaterId
            ).data
        }.onSuccess {
            Log.d("schedule", "schedule get 성공")
        }.onFailure {
            Log.d("schedule", "schedule get 실패..")
        }
}
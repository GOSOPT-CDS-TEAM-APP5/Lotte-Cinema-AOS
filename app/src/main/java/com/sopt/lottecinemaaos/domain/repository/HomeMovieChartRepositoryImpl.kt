package com.sopt.lottecinemaaos.domain.repository

import com.sopt.lottecinemaaos.data.datasource.remote.HomeMovieChartRemoteDataSource
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.data.repository.HomeMovieChartRepository

class HomeMovieChartRepositoryImpl : HomeMovieChartRepository {

    private val remoteDataSource = HomeMovieChartRemoteDataSource

    override fun getMovieChart(callback: HomeMovieChartRepository.GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>) {
        remoteDataSource.getMovieChart(callback)
    }
}
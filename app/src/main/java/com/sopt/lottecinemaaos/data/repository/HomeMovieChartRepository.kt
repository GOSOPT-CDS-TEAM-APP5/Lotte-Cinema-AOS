package com.sopt.lottecinemaaos.data.repository

import com.sopt.lottecinemaaos.data.datasource.remote.HomeMovieChartRemoteDataSource
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto

object HomeMovieChartRepository {
    private val remoteDataSource = HomeMovieChartRemoteDataSource

    fun getMovieChart(callback:GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>){
        remoteDataSource.getMovieChart(callback)
    }

    interface GetDataCallback<T>{
        fun onSuccess(data: T?)
        fun onFailure(throwable: Throwable)
    }
}
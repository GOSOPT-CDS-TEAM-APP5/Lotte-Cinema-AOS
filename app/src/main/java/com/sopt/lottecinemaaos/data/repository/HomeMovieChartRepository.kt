package com.sopt.lottecinemaaos.data.repository

import com.sopt.lottecinemaaos.data.datasource.remote.HomeMovieChartRemoteDataSource
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto

interface HomeMovieChartRepository {
    fun getMovieChart(callback: GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>)
    interface GetDataCallback<T>{
        fun onSuccess(data: T?)
        fun onFailure(throwable: Throwable)
    }
}
package com.sopt.lottecinemaaos.domain.repository

import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto

interface HomeMovieChartRepository {
    fun getMovieChart(callback: GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>)
    interface GetDataCallback<T> {
        fun onSuccess(data: T?)
        fun onFailure(throwable: Throwable)
    }
}

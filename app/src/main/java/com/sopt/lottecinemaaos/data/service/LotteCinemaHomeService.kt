package com.sopt.lottecinemaaos.data.service

import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import retrofit2.Call
import retrofit2.http.GET

interface LotteCinemaHomeService {
    @GET("/main")
    fun getMovieChart() : Call<ArrayList<ResponseHomeMovieChartDto>>
}

package com.sopt.lottecinemaaos.data.service


import com.sopt.lottecinemaaos.data.model.response.ResponseMovieDetailDto
import retrofit2.Call
import retrofit2.http.GET

interface MovieDetailService {
    @GET("/detail/1")
    fun getMovieDetail() : Call<ResponseMovieDetailDto>

}
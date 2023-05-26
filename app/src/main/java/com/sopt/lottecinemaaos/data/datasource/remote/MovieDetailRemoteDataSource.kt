package com.sopt.lottecinemaaos.data.datasource.remote

import com.google.android.material.snackbar.Snackbar
import com.sopt.lottecinemaaos.data.model.ServicePool.movieDetailService
import com.sopt.lottecinemaaos.data.model.response.ResponseMovieDetailDto
import com.sopt.lottecinemaaos.domain.repository.MovieDetailRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieDetailRemoteDataSource {

    fun getMovieDetail(callback: MovieDetailRepository.GetCallback<ResponseMovieDetailDto>){
        movieDetailService.getMovieDetail().enqueue(object :
            Callback<ResponseMovieDetailDto> {
            override fun onResponse(
                call: Call<ResponseMovieDetailDto>,
                response: Response<ResponseMovieDetailDto>
            ) {
                if (response.isSuccessful) {
                    callback.onResponse(response.body())
                }
            }

            override fun onFailure(call: Call<ResponseMovieDetailDto>, t: Throwable) {
                callback.onFailure(t)
            }
        } )
    }
}
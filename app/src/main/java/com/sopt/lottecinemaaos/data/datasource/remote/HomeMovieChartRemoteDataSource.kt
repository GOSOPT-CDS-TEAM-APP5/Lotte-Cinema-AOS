package com.sopt.lottecinemaaos.data.datasource.remote

import com.sopt.lottecinemaaos.data.model.ServicePool.retrofitService
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.domain.repository.HomeMovieChartRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object HomeMovieChartRemoteDataSource {
    fun getMovieChart(callback: HomeMovieChartRepository.GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>) {
        retrofitService.getMovieChart().enqueue(object :
                Callback<ArrayList<ResponseHomeMovieChartDto>> {
                override fun onResponse(
                    call: Call<ArrayList<ResponseHomeMovieChartDto>>,
                    response: Response<ArrayList<ResponseHomeMovieChartDto>>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<ResponseHomeMovieChartDto>>, t: Throwable) {
                    callback.onFailure(t)
                }
            })
    }
}

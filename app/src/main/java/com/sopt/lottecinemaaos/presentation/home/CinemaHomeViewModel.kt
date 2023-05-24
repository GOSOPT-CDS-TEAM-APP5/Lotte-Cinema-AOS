package com.sopt.lottecinemaaos.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.lottecinemaaos.data.model.ServicePool.retrofitService
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.data.repository.HomeMovieChartRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CinemaHomeViewModel : ViewModel() {

    private var _movieChartData: MutableLiveData<ArrayList<ResponseHomeMovieChartDto>> = MutableLiveData()
    val movieChartData: LiveData<ArrayList<ResponseHomeMovieChartDto>>
        get() = _movieChartData

    fun getMovieChart(){
        HomeMovieChartRepository.getMovieChart(object : HomeMovieChartRepository.GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>{
            override fun onSuccess(data: ArrayList<ResponseHomeMovieChartDto>?) {
               data?.let{
                   _movieChartData.value=it
                   Log.e("hyeon",_movieChartData.value.toString())
               }
            }

            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }
        })
    }
}

package com.sopt.lottecinemaaos.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
import com.sopt.lottecinemaaos.data.repository.HomeMovieChartRepositoryImpl
import com.sopt.lottecinemaaos.domain.repository.HomeMovieChartRepository

class CinemaHomeViewModel : ViewModel() {

    private var _movieChartData: MutableLiveData<ArrayList<ResponseHomeMovieChartDto>> = MutableLiveData()
    val movieChartData: LiveData<ArrayList<ResponseHomeMovieChartDto>>
        get() = _movieChartData

    private val repository by lazy {
        HomeMovieChartRepositoryImpl()
    }

    fun getMovieChart(){
        repository.getMovieChart(object : HomeMovieChartRepository.GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>{
                override fun onSuccess(data: ArrayList<ResponseHomeMovieChartDto>?) {
                    data?.let{
                        _movieChartData.value=it
                    }
                }

                override fun onFailure(throwable: Throwable) {
                    throwable.printStackTrace()
                }
            })
        }
    }
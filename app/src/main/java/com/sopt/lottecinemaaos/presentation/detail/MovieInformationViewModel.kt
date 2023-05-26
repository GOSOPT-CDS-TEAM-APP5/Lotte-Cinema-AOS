package com.sopt.lottecinemaaos.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.sopt.lottecinemaaos.data.model.response.ResponseMovieDetailDto
import com.sopt.lottecinemaaos.data.repository.MovieDetailRepositoryImpl
import com.sopt.lottecinemaaos.domain.repository.MovieDetailRepository

class MovieInformationViewModel : ViewModel() {

    private val detailInformation : MutableLiveData<ResponseMovieDetailDto> = MutableLiveData()

    val detailInformationData: LiveData<ResponseMovieDetailDto> get() = detailInformation

    private val repository by lazy {
        MovieDetailRepositoryImpl()
    }

    fun getMovieDetail() {
        repository.getMovieDetail(object : MovieDetailRepository.GetCallback<ResponseMovieDetailDto>{
            override fun onResponse(data: ResponseMovieDetailDto?) {
                data?.let {
                    detailInformation.value = it
                }
            }

            override fun onFailure(throwable: Throwable) {
                throwable.printStackTrace()
            }
        })
    }

}
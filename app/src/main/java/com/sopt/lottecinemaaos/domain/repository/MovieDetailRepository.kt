package com.sopt.lottecinemaaos.domain.repository

import com.sopt.lottecinemaaos.data.model.response.ResponseMovieDetailDto

interface MovieDetailRepository {

    fun getMovieDetail(callback: GetCallback<ResponseMovieDetailDto>)

    interface GetCallback<T> {
        fun onResponse(data: T?)
        fun onFailure(throwable: Throwable)
    }
}
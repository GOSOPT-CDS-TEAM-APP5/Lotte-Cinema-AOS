package com.sopt.lottecinemaaos.data.repository

import com.sopt.lottecinemaaos.data.datasource.remote.MovieDetailRemoteDataSource
import com.sopt.lottecinemaaos.data.model.response.ResponseMovieDetailDto
import com.sopt.lottecinemaaos.domain.repository.MovieDetailRepository

class MovieDetailRepositoryImpl : MovieDetailRepository {

    private val dataSource = MovieDetailRemoteDataSource

    override fun getMovieDetail(callback: MovieDetailRepository.GetCallback<ResponseMovieDetailDto>) {
        dataSource.getMovieDetail(callback)
    }
}
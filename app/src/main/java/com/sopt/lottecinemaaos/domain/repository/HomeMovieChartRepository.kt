<<<<<<<< HEAD:app/src/main/java/com/sopt/lottecinemaaos/domain/repository/HomeMovieChartRepository.kt
package com.sopt.lottecinemaaos.domain.repository

import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto

interface HomeMovieChartRepository {
    fun getMovieChart(callback: GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>)
    interface GetDataCallback<T>{
        fun onSuccess(data: T?)
        fun onFailure(throwable: Throwable)
    }
}
========
// package com.sopt.lottecinemaaos.domain.repository
//
// import com.sopt.lottecinemaaos.data.model.response.ResponseHomeMovieChartDto
//
// interface HomeMovieChartRepository {
//    fun getMovieChart(callback: GetDataCallback<ArrayList<ResponseHomeMovieChartDto>>)
//    interface GetDataCallback<T>{
//        fun onSuccess(data: T?)
//        fun onFailure(throwable: Throwable)
//    }
// }
>>>>>>>> feat/jiyoung:app/src/main/java/com/sopt/lottecinemaaos/data/repository/HomeMovieChartRepository.kt

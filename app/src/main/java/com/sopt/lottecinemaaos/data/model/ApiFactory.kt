package com.sopt.lottecinemaaos.data.model

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.lottecinemaaos.BuildConfig
import com.sopt.lottecinemaaos.data.service.LotteCinemaHomeService
import com.sopt.lottecinemaaos.data.service.MovieDetailService
import com.sopt.lottecinemaaos.data.service.MovieSelectionService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    private val client by lazy {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            }
        ).build()
    }
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.AUTH_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(client)
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val retrofitService = ApiFactory.create<LotteCinemaHomeService>()
    val selectionService = ApiFactory.create<MovieSelectionService>()
    val movieDetailService = ApiFactory.create<MovieDetailService>()
}

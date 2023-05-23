package com.sopt.lottecinemaaos.data.model

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.lottecinemaaos.BuildConfig
import com.sopt.lottecinemaaos.data.service.LotteCinemaService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ApiFactory {
    val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BuildConfig.AUTH_BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create():T = retrofit.create(T::class.java)
}
object ServicePool{
    val retrofitService = ApiFactory.create<LotteCinemaService>()
}
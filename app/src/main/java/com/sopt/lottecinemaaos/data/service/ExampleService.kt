package com.sopt.lottecinemaaos.data.service

import com.sopt.lottecinemaaos.data.model.request.ExampleRequestDto
import com.sopt.lottecinemaaos.data.model.response.ExampleResponseDto
import com.sopt.lottecinemaaos.data.model.response.wrapper.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ExampleService {
    // 예시 API
    @POST("api/example")
    suspend fun postExample(
        @Body request: ExampleRequestDto
    ): BaseResponse<ExampleResponseDto>
}

package com.sopt.lottecinemaaos.domain.repository

import com.sopt.lottecinemaaos.data.model.request.ExampleRequestDto
import com.sopt.lottecinemaaos.data.model.response.ExampleResponseDto
import com.sopt.lottecinemaaos.data.model.response.wrapper.BaseResponse

interface ExampleRepository {
    suspend fun postExample(exampleRequestDto: ExampleRequestDto): Result<BaseResponse<ExampleResponseDto>>
}

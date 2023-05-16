package com.sopt.lottecinemaaos.data.datasource.remote

import com.sopt.lottecinemaaos.data.model.request.ExampleRequestDto
import com.sopt.lottecinemaaos.data.model.response.ExampleResponseDto
import com.sopt.lottecinemaaos.data.model.response.wrapper.BaseResponse
import com.sopt.lottecinemaaos.data.service.ExampleService

class ExampleDataSource(
    private val exampleService: ExampleService
) {
    suspend fun postExample(exampleRequestDto: ExampleRequestDto): BaseResponse<ExampleResponseDto> =
        exampleService.postExample(exampleRequestDto)
}

package com.sopt.lottecinemaaos.domain.repository

import com.sopt.lottecinemaaos.data.datasource.remote.ExampleDataSource
import com.sopt.lottecinemaaos.data.model.request.ExampleRequestDto
import com.sopt.lottecinemaaos.data.model.response.ExampleResponseDto
import com.sopt.lottecinemaaos.data.model.response.wrapper.BaseResponse
import com.sopt.lottecinemaaos.data.repository.ExampleRepository

class ExampleRepositoryImpl(
    private val exampleDataSource: ExampleDataSource
) : ExampleRepository {
    override suspend fun postExample(exampleRequestDto: ExampleRequestDto): Result<BaseResponse<ExampleResponseDto>> =
        kotlin.runCatching { exampleDataSource.postExample(exampleRequestDto) }
}

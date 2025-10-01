package org.mrlem.composesample.features.library.data.datasources.remote.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QueryDto(
    val random: List<RandomDto>?,
    val pages: Map<Long, PageDto>?,
)
package org.mrlem.composesample.features.library.data.datasources.remote.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThumbnailDto(
    val source: String,
)
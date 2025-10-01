package org.mrlem.composesample.features.library.data.datasources.remote.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PageDto(
    @Json(name = "pageid") val pageId: Long,
    val title: String,
    val thumbnail: ThumbnailDto?,
)

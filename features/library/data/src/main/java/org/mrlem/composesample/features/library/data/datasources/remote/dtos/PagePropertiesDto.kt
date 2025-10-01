package org.mrlem.composesample.features.library.data.datasources.remote.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PagePropertiesDto(
    @Json(name = "wikibase-shortdesc") val shortDescription: String?,
)
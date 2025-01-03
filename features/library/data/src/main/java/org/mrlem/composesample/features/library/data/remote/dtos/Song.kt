package org.mrlem.composesample.features.library.data.remote.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Song(
    val title: String,
    val duration: Int,
)
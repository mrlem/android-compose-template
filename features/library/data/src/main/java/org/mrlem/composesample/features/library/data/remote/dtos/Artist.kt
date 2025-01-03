package org.mrlem.composesample.features.library.data.remote.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Artist(
    val name: String,
    val songs: List<Song>,
)
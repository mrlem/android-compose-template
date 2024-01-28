package org.mrlem.sample.compose.features.library.data.remote.dtos

data class Artist(
    val name: String,
    val songs: List<Song>,
)
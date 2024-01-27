package org.mrlem.sample.compose.features.library.domain.model

import kotlin.time.Duration

data class Song(
    val id: Int,
    val title: String,
    val duration: Duration,
    val artist: Artist,
)
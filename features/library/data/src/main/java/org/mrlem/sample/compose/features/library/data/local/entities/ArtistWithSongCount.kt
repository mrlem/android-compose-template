package org.mrlem.sample.compose.features.library.data.local.entities

import androidx.room.Embedded

data class ArtistWithSongCount(
    @Embedded
    val artist: Artist,
    val songCount: Int,
)
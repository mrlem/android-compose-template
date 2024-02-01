package org.mrlem.composesample.features.library.data.local.entities

import androidx.room.Embedded

data class ArtistWithSongCount(
    @Embedded
    val artist: Artist,
    val songCount: Int,
)
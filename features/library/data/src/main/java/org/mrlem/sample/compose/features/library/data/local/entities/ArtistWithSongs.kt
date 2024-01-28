package org.mrlem.sample.compose.features.library.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ArtistWithSongs(
    @Embedded val artist: Artist,
    @Relation(
          parentColumn = "id",
          entityColumn = "artistId"
    )
    val songs: List<Song>,
)

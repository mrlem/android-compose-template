package org.mrlem.sample.compose.features.library.data.local.mappers

import org.mrlem.sample.compose.features.library.data.local.entities.ArtistWithSongCount
import org.mrlem.sample.compose.features.library.domain.model.Artist

object ArtistMapper {

    fun ArtistWithSongCount.toDomain() =
        Artist(
            id = artist.id,
            name = artist.name,
            songCount = songCount,
        )

}
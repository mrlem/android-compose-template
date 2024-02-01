package org.mrlem.composesample.features.library.data.local.mappers

import org.mrlem.composesample.features.library.data.local.entities.Artist as ArtistEntity
import org.mrlem.composesample.features.library.data.local.entities.ArtistWithSongs as ArtistWithSongsEntity
import org.mrlem.composesample.features.library.data.local.entities.ArtistWithSongCount as ArtistWithSongCountEntity
import org.mrlem.composesample.features.library.data.local.mappers.SongMapper.toDomain
import org.mrlem.composesample.features.library.domain.model.Artist
import org.mrlem.composesample.features.library.domain.model.Song

object ArtistMapper {

    fun ArtistEntity.toDomain() =
        Artist(
            id = id,
            name = name,
        )

    fun ArtistWithSongCountEntity.toDomain(): Pair<Artist, Int> =
        artist.toDomain() to songCount

    fun ArtistWithSongsEntity.toDomain(): Pair<Artist, List<Song>> =
        artist.toDomain() to songs.map { it.toDomain() }

}
package org.mrlem.composesample.features.library.data.remote.mappers

import org.mrlem.composesample.features.library.data.local.entities.Artist as ArtistEntity
import org.mrlem.composesample.features.library.data.remote.dtos.Artist as ArtistDto

object ArtistMapper {

    fun ArtistDto.toEntity() =
        ArtistEntity(
            id = 0,
            name = name,
        )

}
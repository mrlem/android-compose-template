package org.mrlem.composesample.features.library.data.local.mappers

import org.mrlem.composesample.features.library.data.local.entities.Song
import kotlin.time.Duration.Companion.seconds

object SongMapper {

    fun Song.toDomain() =
        org.mrlem.composesample.features.library.domain.model.Song(
            id = id,
            title = title,
            duration = duration.seconds,
        )

}
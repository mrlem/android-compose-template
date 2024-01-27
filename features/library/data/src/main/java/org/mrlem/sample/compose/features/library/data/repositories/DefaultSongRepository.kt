package org.mrlem.sample.compose.features.library.data.repositories

import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.domain.model.Song
import org.mrlem.sample.compose.features.library.domain.repositories.SongRepository
import se.ansman.dagger.auto.AutoBind
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.time.Duration.Companion.seconds

@AutoBind
@Singleton
class DefaultSongRepository @Inject constructor() : SongRepository {

    private val artists = listOf(
        Artist(
            id = 0,
            name = "Cocoon",
            songCount = 21,
        ),
        Artist(
            id = 1,
            name = "Elvis Presley",
            songCount = 13,
        ),
        Artist(
            id = 2,
            name = "Muse",
            songCount = 34,
        ),
    )
    private val songs = listOf(
        Song(
            id = 0,
            title = "Let me!",
            artist = artists[0],
            duration = 127.seconds,
        ),
        Song(
            id = 1,
            title = "The final countdown",
            artist = artists[0],
            duration = 148.seconds,
        ),
        Song(
            id = 2,
            title = "Fireworks",
            artist = artists[1],
            duration = 112.seconds,
        ),
        Song(
            id = 3,
            title = "Words are words",
            artist = artists[2],
            duration = 136.seconds,
        ),
    )
    override suspend fun getArtists(): List<Artist> =
        songs
            .map { it.artist }
            .distinct()
            .sortedBy { it.id }

}
package org.mrlem.sample.compose.features.library.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.features.library.data.local.daos.ArtistDao
import org.mrlem.sample.compose.features.library.data.local.daos.SongDao
import org.mrlem.sample.compose.features.library.data.local.entities.Artist as ArtistEntity
import org.mrlem.sample.compose.features.library.data.local.entities.Song as SongEntity
import org.mrlem.sample.compose.features.library.data.local.mappers.ArtistMapper.toDomain
import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.domain.repositories.SongRepository
import se.ansman.dagger.auto.AutoBind
import javax.inject.Inject
import javax.inject.Singleton

@AutoBind
@Singleton
class DefaultSongRepository @Inject constructor(
    private val artistDao: ArtistDao,
    private val songDao: SongDao,
) : SongRepository {

    private val artists = listOf(
        ArtistEntity(
            id = 0,
            name = "Cocoon",
        ),
        ArtistEntity(
            id = 1,
            name = "Elvis Presley",
        ),
        ArtistEntity(
            id = 2,
            name = "Muse",
        ),
    )

    private val songs = listOf(
        SongEntity(
            id = 0,
            title = "Let me!",
            duration = 127,
            artistId = 0,
        ),
        SongEntity(
            id = 1,
            title = "The final countdown",
            duration = 148,
            artistId = 0,
        ),
        SongEntity(
            id = 2,
            title = "Fireworks",
            duration = 112,
            artistId = 1,
        ),
        SongEntity(
            id = 3,
            title = "Words are words",
            duration = 136,
            artistId = 2,
        ),
    )

    init {
        GlobalScope.launch(Dispatchers.IO) {
            songDao.clear()
            artistDao.clear()

            artistDao.add(*artists.toTypedArray())
            delay(1000)
            songDao.add(*songs.toTypedArray())
        }
    }

    override suspend fun getArtists(): List<Artist> =
        artistDao.listArtistWithSongCount()
            .map { it.toDomain() }

    override suspend fun getArtist(id: Int): Artist? =
        artistDao.findArtistWithSongCount(id)
            ?.toDomain()

}
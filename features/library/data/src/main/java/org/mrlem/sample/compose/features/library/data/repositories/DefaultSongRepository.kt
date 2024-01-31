package org.mrlem.sample.compose.features.library.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.mrlem.sample.compose.features.library.data.local.daos.ArtistDao
import org.mrlem.sample.compose.features.library.data.local.daos.SongDao
import org.mrlem.sample.compose.features.library.data.local.mappers.ArtistMapper.toDomain
import org.mrlem.sample.compose.features.library.data.remote.api.SongsApi
import org.mrlem.sample.compose.features.library.data.remote.mappers.ArtistMapper.toEntity
import org.mrlem.sample.compose.features.library.data.remote.mappers.SongMapper.toEntity
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
    private val songsApi: SongsApi,
) : SongRepository {

    init {
        initDatabase()
    }

    override fun getArtists(): Flow<List<Artist>> =
        artistDao.listArtistWithSongCount()
            .map { artists -> artists.map { it.toDomain() } }

    override suspend fun getArtist(id: Long): Artist? =
        artistDao.findArtistWithSongCount(id)
            ?.toDomain()

    override suspend fun download(): Int =
        withTimeout(500) {
            val artists = songsApi.list()

            artists.forEach { artist ->
                val artistId = artistDao.add(artist.toEntity())
                songDao.add(*artist.songs.map { it.toEntity(artistId) }.toTypedArray())
            }

            artists
                .sumOf { it.songs.count() }
        }

    override suspend fun findArtistIdByName(name: String): Long? =
        artistDao.findArtistIdByName("Muse")

    private fun initDatabase() {
        // wait until our test data to be populated before to consider repo ready to use
        runBlocking {
            songDao.clear()
            artistDao.clear()
            SampleData.artists
                .map { artist -> artist to SampleData.songs.filter { it.artistId == artist.id } }
                .forEach { artistAndSongs ->
                    val artistId = artistDao.add(artistAndSongs.first.copy(id = 0))
                    songDao.add(
                        *artistAndSongs.second
                            .map { it.copy(id = 0, artistId = artistId) }
                            .toTypedArray()
                    )
                }
        }
    }

}
package org.mrlem.composesample.features.library.data.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import org.mrlem.android.core.di.ApplicationScope
import org.mrlem.composesample.features.library.data.local.daos.ArtistDao
import org.mrlem.composesample.features.library.data.local.daos.SongDao
import org.mrlem.composesample.features.library.data.local.mappers.ArtistMapper.toDomain
import org.mrlem.composesample.features.library.data.remote.api.SongsApi
import org.mrlem.composesample.features.library.data.remote.mappers.ArtistMapper.toEntity
import org.mrlem.composesample.features.library.data.remote.mappers.SongMapper.toEntity
import org.mrlem.composesample.features.library.domain.model.Artist
import org.mrlem.composesample.features.library.domain.model.Song
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import se.ansman.dagger.auto.AutoBind
import javax.inject.Inject
import javax.inject.Singleton

@AutoBind
@Singleton
class DefaultSongRepository @Inject constructor(
    private val artistDao: ArtistDao,
    private val songDao: SongDao,
    private val songsApi: SongsApi,
    @ApplicationScope private val coroutineScope: CoroutineScope,
) : SongRepository {

    companion object {

        private const val TIMEOUT = 1000L

    }

    init {
        initDatabase()
    }

    override fun getArtists(): Flow<List<Pair<Artist, Int>>> =
        artistDao.listArtistWithSongCount()
            .map { artistWithSongCount -> artistWithSongCount.map { it.toDomain() } }

    override suspend fun getArtist(id: Long): Pair<Artist, List<Song>>? =
        artistDao.findArtistWithSongs(id)
            ?.toDomain()

    override suspend fun download(): Int =
        withTimeout(TIMEOUT) {
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
        // In this sample, wait until our test data gets populated before we consider the repo ready.
        // In a real-life app we wouldn't do this, but the spotlight screen has a hardcoded link.
        coroutineScope.launch {
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
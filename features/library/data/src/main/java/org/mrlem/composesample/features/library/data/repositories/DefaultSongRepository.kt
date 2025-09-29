package org.mrlem.composesample.features.library.data.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
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

    private val ready = MutableStateFlow(false)

    init {
        initDatabase()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getArtists(): Flow<List<Pair<Artist, Int>>> =
        ready
            .filter { it }
            .flatMapLatest {
                artistDao.listArtistWithSongCount()
                    .map { artistWithSongCount -> artistWithSongCount.map { it.toDomain() } }
            }

    override suspend fun getArtist(id: Long): Pair<Artist, List<Song>>? {
        ready.first { it }
        return artistDao.findArtistWithSongs(id)
            ?.toDomain()
    }

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

    override suspend fun findArtistIdByName(name: String): Long? {
        ready.first { it }
        return artistDao.findArtistIdByName(name)
    }

    private fun initDatabase() {
        coroutineScope.launch(Dispatchers.Default) {
            songDao.clear()
            artistDao.clear()
            SampleData.artists
                .map { artist -> artist to SampleData.songs.filter { it.artistId == artist.id } }
                .forEach { (artist, songs) ->
                    val artistId = artistDao.add(artist.copy(id = 0))
                    songDao.add(
                        *songs
                            .map { it.copy(id = 0, artistId = artistId) }
                            .toTypedArray()
                    )
                }
            ready.value = true
        }
    }

}
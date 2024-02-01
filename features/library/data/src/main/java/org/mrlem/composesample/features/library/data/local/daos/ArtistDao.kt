package org.mrlem.composesample.features.library.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import org.mrlem.composesample.features.library.data.local.entities.Artist
import org.mrlem.composesample.features.library.data.local.entities.ArtistWithSongCount
import org.mrlem.composesample.features.library.data.local.entities.ArtistWithSongs

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(artist: Artist): Long

    @Query("DELETE FROM artist")
    suspend fun clear()

    @Query("SELECT id FROM artist WHERE name LIKE :name")
    suspend fun findArtistIdByName(name: String): Long?

    @Transaction
    @Query("SELECT * FROM artist WHERE id = :id")
    suspend fun findArtistWithSongs(id: Long): ArtistWithSongs?

    @Transaction
    @Query("SELECT artist.*, COUNT(song.id) AS songCount FROM artist LEFT JOIN song ON artist.id = song.artistId GROUP BY artist.id")
    fun listArtistWithSongCount(): Flow<List<ArtistWithSongCount>>

    @Transaction
    @Query("SELECT artist.*, COUNT(song.id) AS songCount FROM artist LEFT JOIN song ON artist.id = song.artistId WHERE artist.id = :id")
    suspend fun findArtistWithSongCount(id: Long): ArtistWithSongCount?

}
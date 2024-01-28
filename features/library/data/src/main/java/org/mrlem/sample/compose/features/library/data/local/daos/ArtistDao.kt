package org.mrlem.sample.compose.features.library.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import org.mrlem.sample.compose.features.library.data.local.entities.Artist
import org.mrlem.sample.compose.features.library.data.local.entities.ArtistWithSongCount
import org.mrlem.sample.compose.features.library.data.local.entities.ArtistWithSongs

@Dao
interface ArtistDao {

    @Insert
    suspend fun add(vararg artist: Artist)

    @Query("DELETE FROM artist")
    suspend fun clear()

    @Transaction
    @Query("SELECT * FROM artist WHERE id = :id")
    suspend fun findArtistWithSongs(id: Int): ArtistWithSongs?

    @Transaction
    @Query("SELECT artist.*, COUNT(song.id) AS songCount FROM artist LEFT JOIN song ON artist.id = song.artistId GROUP BY artist.id")
    suspend fun listArtistWithSongCount(): List<ArtistWithSongCount>

    @Transaction
    @Query("SELECT artist.*, COUNT(song.id) AS songCount FROM artist LEFT JOIN song ON artist.id = song.artistId WHERE artist.id = :id")
    suspend fun findArtistWithSongCount(id: Int): ArtistWithSongCount?

}
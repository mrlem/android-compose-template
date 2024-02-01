package org.mrlem.composesample.features.library.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.mrlem.composesample.features.library.data.local.entities.Song

@Dao
interface SongDao {

    @Query("SELECT * FROM song")
    suspend fun list(): List<Song>

    @Insert
    suspend fun add(vararg songs: Song)

    @Query("DELETE FROM song")
    suspend fun clear()

}
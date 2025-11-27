package org.mrlem.composesample.features.library.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.mrlem.composesample.features.library.data.datasources.local.entities.BookmarkEntity

@Dao
interface BookmarkDataSource {

    // FIXME - should not return full object
    @Query("SELECT * FROM bookmark")
    fun list(): Flow<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun add(bookmark: BookmarkEntity): Long

    @Query("SELECT * FROM bookmark WHERE id = :id")
    suspend fun get(id: Long): BookmarkEntity
}
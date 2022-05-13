package org.mrlem.sample.compose.feature.feature1.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.mrlem.sample.compose.feature.feature1.data.local.entity.FilmEntity

@Dao
interface FilmDao {

    ///////////////////////////////////////////////////////////////////////////
    // Query
    ///////////////////////////////////////////////////////////////////////////

    @Query("SELECT * FROM film1")
    fun list(): Flow<List<FilmEntity>>

    @Query("SELECT * FROM film1 WHERE id = :id")
    fun getById(id: String): Flow<FilmEntity>

    ///////////////////////////////////////////////////////////////////////////
    // Insert
    ///////////////////////////////////////////////////////////////////////////

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(film: FilmEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(films: List<FilmEntity>)

    ///////////////////////////////////////////////////////////////////////////
    // Update
    ///////////////////////////////////////////////////////////////////////////

    @Query("UPDATE film1 SET isFavorite = 1 WHERE id = :id")
    suspend fun favorite(id: String)

    @Query("UPDATE film1 SET isFavorite = 0 WHERE id = :id")
    suspend fun unfavorite(id: String)

}
package org.mrlem.sample.compose.feature.favorites.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert
    suspend fun insert(favorite: Favorite)

    @Delete
    suspend fun delete(favorite: Favorite)

    @Query("SELECT * FROM favorite")
    fun list(): Flow<List<Favorite>>

    @Query("SELECT * FROM favorite WHERE filmId = :filmId")
    fun getByFilmId(filmId: String): Flow<Favorite?>

}
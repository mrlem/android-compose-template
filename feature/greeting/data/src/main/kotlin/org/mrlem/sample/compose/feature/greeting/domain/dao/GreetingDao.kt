package org.mrlem.sample.compose.feature.greeting.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.mrlem.sample.compose.feature.greeting.domain.entity.Greeting

@Dao
interface GreetingDao {

    @Insert
    suspend fun insert(greeting: Greeting)

    @Query("SELECT * FROM greeting")
    fun list(): Flow<List<Greeting>>

}
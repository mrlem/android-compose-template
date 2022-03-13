package org.mrlem.sample.compose

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.feature.ghibli.data.local.GhibliDatabase
import org.mrlem.sample.compose.feature.ghibli.data.local.FilmEntity

/**
 * Database that merged all feature-contributed databases. Should:
 * - list entities (from all features)
 * - extend database interfaces (from all features)
 */
@Database(entities = [FilmEntity::class], version = 2)
abstract class MainDatabase : RoomDatabase(),
    GhibliDatabase

@Module
@InstallIn(SingletonComponent::class)
@Suppress("unused")
interface DatabaseModule {

    @Binds
    fun ghibliDatabase(database: MainDatabase): GhibliDatabase

}
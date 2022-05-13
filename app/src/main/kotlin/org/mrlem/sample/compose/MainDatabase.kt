package org.mrlem.sample.compose

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.feature.feature1.data.local.dao.GhibliDatabase
import org.mrlem.sample.compose.feature.feature1.data.local.entity.FilmEntity

/**
 * Database that merged all feature-contributed databases. Should:
 * - list entities (from all features)
 * - extend database interfaces (from all features)
 */
@Database(entities = [
    FilmEntity::class,
    org.mrlem.sample.compose.feature.feature2.data.local.entity.FilmEntity::class,
    org.mrlem.sample.compose.feature.feature3.data.local.entity.FilmEntity::class,
], version = 2)
abstract class MainDatabase : RoomDatabase(),
    GhibliDatabase,
    org.mrlem.sample.compose.feature.feature2.data.local.dao.GhibliDatabase,
    org.mrlem.sample.compose.feature.feature3.data.local.dao.GhibliDatabase

@Module
@InstallIn(SingletonComponent::class)
@Suppress("unused")
interface DatabaseModule {

    @Binds
    fun ghibli1Database(database: MainDatabase): GhibliDatabase

    @Binds
    fun ghibli2Database(database: MainDatabase): org.mrlem.sample.compose.feature.feature2.data.local.dao.GhibliDatabase

    @Binds
    fun ghibli3Database(database: MainDatabase): org.mrlem.sample.compose.feature.feature3.data.local.dao.GhibliDatabase

}
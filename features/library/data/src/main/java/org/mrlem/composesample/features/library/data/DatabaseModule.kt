package org.mrlem.composesample.features.library.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.mrlem.composesample.features.library.data.local.AppDatabase
import org.mrlem.composesample.features.library.data.local.daos.ArtistDao
import org.mrlem.composesample.features.library.data.local.daos.SongDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun database(@ApplicationContext context: Context): AppDatabase =
        Room
            .databaseBuilder(
                context,
                AppDatabase::class.java, "database-name"
            )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun artistDao(database: AppDatabase): ArtistDao =
        database.artistDao()

    @Provides
    fun songDao(database: AppDatabase): SongDao =
        database.songDao()

}
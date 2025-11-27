package org.mrlem.composesample.features.library.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.mrlem.composesample.features.library.data.datasources.local.BookmarkDataSource
import org.mrlem.composesample.features.library.data.local.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun database(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            klass = AppDatabase::class.java,
            name = "database-name",
        )
            .fallbackToDestructiveMigration(false)
            .build()

    @Provides
    fun bookmarkDataSource(database: AppDatabase): BookmarkDataSource =
        database.bookmarkDataSource()
}
package org.mrlem.composesample.features.library.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import org.mrlem.composesample.features.library.data.datasources.local.BookmarkDataSource
import org.mrlem.composesample.features.library.data.datasources.local.entities.BookmarkEntity

@Database(entities = [BookmarkEntity::class], version = 5)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookmarkDataSource(): BookmarkDataSource

}

package org.mrlem.composesample.features.library.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import org.mrlem.composesample.features.library.data.local.daos.ArtistDao
import org.mrlem.composesample.features.library.data.local.daos.SongDao
import org.mrlem.composesample.features.library.data.local.entities.Artist
import org.mrlem.composesample.features.library.data.local.entities.Song

@Database(entities = [Song::class, Artist::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    abstract fun songDao(): SongDao

    abstract fun artistDao(): ArtistDao

}

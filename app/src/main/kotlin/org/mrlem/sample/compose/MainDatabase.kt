package org.mrlem.sample.compose

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.feature.greeting.data.GreetingDatabase
import org.mrlem.sample.compose.feature.greeting.data.entity.Greeting

@Database(entities = [Greeting::class], version = 1)
abstract class MainDatabase : RoomDatabase(),
    GreetingDatabase

@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModule {

    @Binds
    abstract fun provideGreetingDatabase(database: MainDatabase): GreetingDatabase

}
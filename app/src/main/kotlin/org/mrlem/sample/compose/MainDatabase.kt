package org.mrlem.sample.compose

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.feature.greeting.domain.GreetingDatabase
import org.mrlem.sample.compose.feature.greeting.domain.entity.Greeting

@Database(entities = [Greeting::class], version = 1)
abstract class MainDatabase : RoomDatabase(),
    GreetingDatabase

@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModule {

    @Binds
    abstract fun provideGreetingDatabase(database: MainDatabase): GreetingDatabase

}
package org.mrlem.sample.compose

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.feature.greeting.domain.dao.GreetingDao
import org.mrlem.sample.compose.feature.greeting.domain.entity.Greeting
import javax.inject.Singleton

@Database(entities = [Greeting::class], version = 1)
abstract class MainDatabase : RoomDatabase() {

    abstract fun greetingDao(): GreetingDao

}

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MainDatabase {
        return Room.databaseBuilder(
            appContext,
            MainDatabase::class.java,
            "sample",
        )
            .build()
    }

    @Provides
    fun provideGreetingDao(database: MainDatabase): GreetingDao {
        return database.greetingDao()
    }

}
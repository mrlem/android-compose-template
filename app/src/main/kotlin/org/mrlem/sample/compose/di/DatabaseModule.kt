package org.mrlem.sample.compose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.MainDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun database(@ApplicationContext appContext: Context): MainDatabase =
        Room.databaseBuilder(
            appContext,
            MainDatabase::class.java,
            "sample",
        )
            .build()

}
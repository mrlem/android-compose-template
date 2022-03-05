package org.mrlem.sample.compose.feature.greeting.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.feature.greeting.data.dao.GreetingDao

interface GreetingDatabase {

    fun greetingDao(): GreetingDao

}

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideGreetingDao(database: GreetingDatabase) = database.greetingDao()

}
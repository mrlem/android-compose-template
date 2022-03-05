package org.mrlem.sample.compose.feature.greeting.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import org.mrlem.sample.compose.feature.greeting.data.Module.Bindings
import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepository
import org.mrlem.sample.compose.feature.greeting.data.repository.GreetingRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module(includes = [ Bindings::class ])
class Module {

    @Module
    @DisableInstallInCheck
    interface Bindings {

        @Binds
        fun provideGreetingRepository(impl: GreetingRepositoryImpl): GreetingRepository

    }

    @Provides
    fun provideGreetingDao(database: GreetingDatabase) = database.greetingDao()

}
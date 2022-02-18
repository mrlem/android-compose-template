package org.mrlem.sample.compose.feature.greeting.domain

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepository
import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class Module {

    @Binds
    abstract fun provide(impl: GreetingRepositoryImpl): GreetingRepository

}
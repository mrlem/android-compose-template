package org.mrlem.sample.compose.feature.greeting.domain

import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GreetingManager @Inject constructor(
    private val repository: GreetingRepository,
) {

    suspend fun greet() {
        repository.add("Plop")
    }

}
package org.mrlem.sample.compose.feature.greeting.domain.repository

import kotlinx.coroutines.flow.Flow
import org.mrlem.sample.compose.feature.greeting.domain.model.Greeting

interface GreetingRepository {

    val greetings: Flow<List<Greeting>>

    suspend fun add(text: String)

}
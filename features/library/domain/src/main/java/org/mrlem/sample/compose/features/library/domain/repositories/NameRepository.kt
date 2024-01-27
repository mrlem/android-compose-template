package org.mrlem.sample.compose.features.library.domain.repositories

interface NameRepository {

    suspend fun getName(): String

}
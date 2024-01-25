package org.mrlem.sample.compose.features.home.domain.repositories

interface NameRepository {

    suspend fun getName(): String

}
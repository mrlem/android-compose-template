package org.mrlem.sample.compose.feature.feature2.data.local.dao

/**
 * Provides access to all Room DAOs in the feature.
 */
interface GhibliDatabase {

    fun film2Dao(): FilmDao

}
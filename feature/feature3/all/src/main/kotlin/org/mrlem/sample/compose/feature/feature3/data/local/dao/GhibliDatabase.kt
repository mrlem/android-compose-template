package org.mrlem.sample.compose.feature.feature3.data.local.dao

/**
 * Provides access to all Room DAOs in the feature.
 */
interface GhibliDatabase {

    fun film3Dao(): FilmDao

}
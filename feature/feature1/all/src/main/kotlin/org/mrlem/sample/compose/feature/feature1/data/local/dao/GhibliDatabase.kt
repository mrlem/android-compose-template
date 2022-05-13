package org.mrlem.sample.compose.feature.feature1.data.local.dao

/**
 * Provides access to all Room DAOs in the feature.
 */
interface GhibliDatabase {

    fun film1Dao(): FilmDao

}
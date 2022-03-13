package org.mrlem.sample.compose.feature.ghibli.data.local

/**
 * Provides access to all Room DAOs in the feature.
 */
interface GhibliDatabase {

    fun filmDao(): FilmDao

}
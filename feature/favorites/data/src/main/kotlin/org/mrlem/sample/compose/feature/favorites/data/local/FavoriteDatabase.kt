package org.mrlem.sample.compose.feature.favorites.data.local


/**
 * Provides access to all Room DAOs in the feature.
 */
interface FavoriteDatabase {

    fun favoriteDao(): FavoriteDao

}
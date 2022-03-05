package org.mrlem.sample.compose.feature.greeting.data

import org.mrlem.sample.compose.feature.greeting.data.dao.GreetingDao

/**
 * Provides access to all Room DAOs in the feature.
 */
interface GreetingDatabase {

    fun greetingDao(): GreetingDao

}
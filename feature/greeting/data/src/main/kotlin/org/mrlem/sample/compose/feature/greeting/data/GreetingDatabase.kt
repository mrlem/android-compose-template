package org.mrlem.sample.compose.feature.greeting.data

import org.mrlem.sample.compose.feature.greeting.data.dao.GreetingDao

interface GreetingDatabase {

    fun greetingDao(): GreetingDao

}
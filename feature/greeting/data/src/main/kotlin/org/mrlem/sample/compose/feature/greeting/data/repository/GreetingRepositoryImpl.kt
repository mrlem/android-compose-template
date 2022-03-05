package org.mrlem.sample.compose.feature.greeting.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.mrlem.sample.compose.feature.greeting.data.dao.GreetingDao
import org.mrlem.sample.compose.feature.greeting.domain.model.Greeting
import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepository
import javax.inject.Inject

class GreetingRepositoryImpl @Inject constructor(
    private val greetingDao: GreetingDao,
) : GreetingRepository {

    override val greetings: Flow<List<Greeting>> = greetingDao.list()
        .map { greetings -> greetings.map { it.toModel() } }
        .flowOn(Dispatchers.IO)

    override suspend fun add(text: String) {
        greetingDao.insert(
            org.mrlem.sample.compose.feature.greeting.data.entity.Greeting(
            text = text,
        ))
    }

}
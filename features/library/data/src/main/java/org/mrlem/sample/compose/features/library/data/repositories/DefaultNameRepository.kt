package org.mrlem.sample.compose.features.library.data.repositories

import org.mrlem.sample.compose.features.library.domain.repositories.NameRepository
import se.ansman.dagger.auto.AutoBind
import javax.inject.Inject
import javax.inject.Singleton

@AutoBind
@Singleton
class DefaultNameRepository @Inject constructor() : NameRepository {

    override suspend fun getName(): String =
        "Seb"

}
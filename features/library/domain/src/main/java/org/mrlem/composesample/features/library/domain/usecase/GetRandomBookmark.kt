package org.mrlem.composesample.features.library.domain.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import org.mrlem.composesample.features.library.domain.model.Bookmark
import org.mrlem.composesample.features.library.domain.repositories.BookmarkRepository
import javax.inject.Inject
import kotlin.random.Random

class GetRandomBookmark @Inject constructor(
    private val repository: BookmarkRepository,
) {

    operator fun invoke(): Flow<Bookmark?> =
        repository.bookmarks
            .map { items ->
                items
                    .takeIf { it.isNotEmpty() }
                    ?: return@map null

                val randomIndex = Random.nextInt(items.count())
                return@map items[randomIndex].id
            }
            .map { randomId -> randomId?.let { repository.get(it) } }
            .distinctUntilChanged()
            .flowOn(Dispatchers.Default)

}
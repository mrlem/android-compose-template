package org.mrlem.composesample.features.library.data.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.di.ApplicationScope
import org.mrlem.composesample.features.library.data.datasources.local.BookmarkDataSource
import org.mrlem.composesample.features.library.data.datasources.local.BookmarkMapper
import org.mrlem.composesample.features.library.data.datasources.remote.WikipediaDataSource
import org.mrlem.composesample.features.library.data.datasources.remote.WikipediaMapper
import org.mrlem.composesample.features.library.domain.model.Bookmark
import org.mrlem.composesample.features.library.domain.model.BookmarkItem
import org.mrlem.composesample.features.library.domain.repositories.BookmarkRepository
import se.ansman.dagger.auto.AutoBind
import javax.inject.Inject
import javax.inject.Singleton

@AutoBind
@Singleton
internal class DefaultBookmarkRepository @Inject constructor(
    private val bookmarkDataSource: BookmarkDataSource,
    private val bookmarkMapper: BookmarkMapper,
    private val wikipediaDataSource: WikipediaDataSource,
    private val wikipediaMapper: WikipediaMapper,
    @ApplicationScope scope: CoroutineScope,
) : BookmarkRepository {

    override val bookmarks: StateFlow<List<BookmarkItem>> =
        bookmarkDataSource.list()
            .map { bookmarks -> bookmarkMapper.toDomain(bookmarks) }
            .stateIn(scope, WhileSubscribed(), emptyList())

    override suspend fun add(bookmark: Bookmark): Long =
        bookmarkDataSource
            .add(bookmarkMapper.toEntity(bookmark))

    override suspend fun get(id: Long): Bookmark =
        bookmarkMapper
            .toDomain(bookmarkDataSource.get(id))

    override suspend fun delete(id: Long) {
        bookmarkDataSource.delete(id)
    }

    override suspend fun getRandom(): String =
        wikipediaMapper
            .toRandomName(wikipediaDataSource.findRandom())

    override suspend fun import(name: String): Bookmark =
        wikipediaMapper
            .toDomain(wikipediaDataSource.findByName(name))
}
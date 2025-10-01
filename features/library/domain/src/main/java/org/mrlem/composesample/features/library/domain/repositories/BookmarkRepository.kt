package org.mrlem.composesample.features.library.domain.repositories

import kotlinx.coroutines.flow.StateFlow
import org.mrlem.composesample.features.library.domain.model.Bookmark
import org.mrlem.composesample.features.library.domain.model.BookmarkItem

interface BookmarkRepository {

    val bookmarks: StateFlow<List<BookmarkItem>>

    suspend fun add(bookmark: Bookmark): Long
    suspend fun get(id: Long): Bookmark
    suspend fun getRandom(): String
    suspend fun import(name: String): Bookmark

}
package org.mrlem.composesample.features.library.data.datasources.local

import org.mrlem.composesample.features.library.data.datasources.local.entities.BookmarkEntity
import org.mrlem.composesample.features.library.domain.model.Bookmark
import org.mrlem.composesample.features.library.domain.model.BookmarkItem
import javax.inject.Inject

internal class BookmarkMapper @Inject constructor() {

    fun toDomain(entities: List<BookmarkEntity>): List<BookmarkItem> =
        entities.map { entity ->
            BookmarkItem(
                id = entity.id,
                name = entity.name,
            )
        }

    fun toDomain(entity: BookmarkEntity): Bookmark =
        Bookmark(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            image = entity.image,
        )

    fun toEntity(domain: Bookmark): BookmarkEntity =
        BookmarkEntity(
            id = domain.id,
            name = domain.name,
            description = domain.description,
            image = domain.image,
        )
}
package org.mrlem.composesample.features.library.data.datasources.remote

import org.mrlem.composesample.features.library.data.datasources.remote.dtos.ResultDto
import org.mrlem.composesample.features.library.domain.model.Bookmark
import javax.inject.Inject

internal class WikipediaMapper @Inject constructor() {

    fun toRandomName(dto: ResultDto): String =
        dto.query.random!![0].title

    fun toDomain(dto: ResultDto): Bookmark {
        val page = dto.query.pages!!.values.first()
        return Bookmark(
            id = page.pageId,
            name = page.title,
            description = page.properties?.shortDescription,
            image = page.thumbnail?.source,
        )
    }

}
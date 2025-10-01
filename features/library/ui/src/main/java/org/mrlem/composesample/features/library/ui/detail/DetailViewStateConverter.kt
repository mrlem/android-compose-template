package org.mrlem.composesample.features.library.ui.detail

import org.mrlem.composesample.features.library.domain.model.Bookmark
import javax.inject.Inject

internal class DetailViewStateConverter @Inject constructor() {

    fun toViewState(bookmark: Bookmark) =
        DetailViewState(
            name = bookmark.name,
            description = bookmark.description,
            image = bookmark.image,
        )

}
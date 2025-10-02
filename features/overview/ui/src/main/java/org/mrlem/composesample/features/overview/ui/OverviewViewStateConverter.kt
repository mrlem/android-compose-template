package org.mrlem.composesample.features.overview.ui

import org.mrlem.composesample.features.library.domain.model.Bookmark
import javax.inject.Inject

internal class OverviewViewStateConverter @Inject constructor() {

    fun toViewState(bookmark: Bookmark?): OverviewViewState =
        OverviewViewState(
            suggestionName = bookmark?.name,
            suggestionImage = bookmark?.image,
            suggestionId = bookmark?.id,
        )

}
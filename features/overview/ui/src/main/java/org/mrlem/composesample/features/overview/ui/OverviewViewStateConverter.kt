package org.mrlem.composesample.features.overview.ui

import org.mrlem.composesample.features.library.domain.model.Bookmark
import javax.inject.Inject

internal class OverviewViewStateConverter @Inject constructor() {

    // TODO - should render with thumbnail
    fun toViewState(bookmark: Bookmark?): OverviewViewState =
        OverviewViewState(
            buttonBookmarkId = bookmark?.id,
        )

}
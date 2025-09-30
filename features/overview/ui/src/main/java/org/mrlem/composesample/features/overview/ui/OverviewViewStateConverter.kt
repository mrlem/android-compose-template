package org.mrlem.composesample.features.overview.ui

import javax.inject.Inject

internal class OverviewViewStateConverter @Inject constructor() {

    fun toViewState(artistId: Long) =
        OverviewViewState(
            buttonArtistId = artistId,
        )

}
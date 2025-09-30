package org.mrlem.composesample.features.spotlight.ui

import javax.inject.Inject

internal class SpotlightViewStateConverter @Inject constructor() {

    fun toViewState(artistId: Long) =
        SpotlightViewState(
            buttonArtistId = artistId,
        )

}
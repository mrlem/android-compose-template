package org.mrlem.sample.compose.features.library.ui.artist

import org.mrlem.sample.compose.features.library.domain.model.Artist

object ArtistViewStateConverter {

    fun Artist.toViewState() =
        ArtistViewState(
            name = name,
        )

}
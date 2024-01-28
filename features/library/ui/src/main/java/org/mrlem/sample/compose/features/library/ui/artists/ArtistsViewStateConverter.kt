package org.mrlem.sample.compose.features.library.ui.artists

import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.ui.ItemViewState

internal object ArtistsViewStateConverter {

    fun List<Artist>.toViewState() =
        map { it.toViewState() }

    private fun Artist.toViewState() =
        ItemViewState<ArtistsViewAction>(
            label = name,
            description = "$songCount songs", // TODO - use plural string
            onClickAction = ArtistsViewAction.ArtistClick(id),
        )

}
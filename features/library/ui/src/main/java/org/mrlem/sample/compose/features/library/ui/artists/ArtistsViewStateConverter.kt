package org.mrlem.sample.compose.features.library.ui.artists

import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.ui.ItemViewState

object ArtistsViewStateConverter {

    fun List<Artist>.toViewState() =
        map { it.toViewState() }

    fun Artist.toViewState() =
        ItemViewState<ArtistsViewAction>(
            label = name,
            description = "$songCount songs", // TODO - use plural string
            onClickAction = ArtistsViewAction.SelectArtist(id),
        )

}
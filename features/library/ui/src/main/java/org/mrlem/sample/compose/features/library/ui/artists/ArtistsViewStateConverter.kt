package org.mrlem.sample.compose.features.library.ui.artists

import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.ui.ItemViewState

internal object ArtistsViewStateConverter {

    fun List<Pair<Artist, Int>>.toViewState() =
        map { it.toViewState() }

    private fun Pair<Artist, Int>.toViewState() =
        ItemViewState<ArtistsViewAction>(
            label = first.name,
            description = "$second songs", // TODO - use plural string
            onClickAction = ArtistsViewAction.ArtistClick(first.id),
        )

}
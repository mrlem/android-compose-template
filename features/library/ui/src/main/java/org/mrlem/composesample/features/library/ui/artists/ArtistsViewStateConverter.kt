package org.mrlem.composesample.features.library.ui.artists

import org.mrlem.composesample.features.library.domain.model.Artist
import org.mrlem.composesample.features.library.ui.ItemViewState
import javax.inject.Inject

internal class ArtistsViewStateConverter @Inject constructor() {

    fun toViewState(artistsAndSongCount: List<Pair<Artist, Int>>) =
        ArtistsViewState(
            items = artistsAndSongCount.map { it.toViewState() },
        )

    private fun Pair<Artist, Int>.toViewState() =
        ItemViewState<ArtistsViewAction>(
            label = first.name,
            description = "$second songs", // TODO - use plural string
            onClickAction = ArtistsViewAction.ArtistClick(first.id),
        )

}
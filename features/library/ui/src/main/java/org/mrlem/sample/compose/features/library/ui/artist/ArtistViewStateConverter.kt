package org.mrlem.sample.compose.features.library.ui.artist

import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.domain.model.Song
import org.mrlem.sample.compose.features.library.domain.usecase.FormatDurationUseCase
import javax.inject.Inject

internal class ArtistViewStateConverter @Inject constructor(
    private val formatDurationUseCase: FormatDurationUseCase,
) {

    fun Pair<Artist, List<Song>>.toViewState() =
        ArtistViewState(
            name = first.name,
            songs = second.map { it.toViewState() }
        )

    fun Song.toViewState() =
        ArtistViewState.Song(
            name = title,
            duration = formatDurationUseCase(duration),
        )

}
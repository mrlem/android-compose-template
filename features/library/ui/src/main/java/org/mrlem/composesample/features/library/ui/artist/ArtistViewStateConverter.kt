package org.mrlem.composesample.features.library.ui.artist

import org.mrlem.composesample.features.library.domain.model.Artist
import org.mrlem.composesample.features.library.domain.model.Song
import org.mrlem.composesample.features.library.domain.usecase.FormatDurationUseCase
import javax.inject.Inject

internal class ArtistViewStateConverter @Inject constructor(
    private val formatDurationUseCase: FormatDurationUseCase,
) {

    fun toViewState(artist: Artist, songs: List<Song>) =
        ArtistViewState(
            name = artist.name,
            songs = songs.map { it.toViewState() },
        )

    private fun Song.toViewState() =
        ArtistViewState.Song(
            name = title,
            duration = formatDurationUseCase(duration),
        )

}
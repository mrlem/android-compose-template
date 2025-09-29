package org.mrlem.composesample.features.library.ui.artist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import javax.inject.Inject

@HiltViewModel
internal class ArtistViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    songRepository: SongRepository,
    artistViewStateConverter: ArtistViewStateConverter,
): UnidirectionalViewModel<ArtistViewState, Unit, Unit>() {

    override val state = MutableStateFlow(ArtistViewState())

    private val artistId = ArtistDestination.Args(savedStateHandle).id

    init {
        viewModelScope.launch {
            val artistWithSongs = checkNotNull(songRepository.getArtist(artistId))
            with(artistViewStateConverter) {
                state.update { artistWithSongs.toViewState() }
            }
        }
    }

}
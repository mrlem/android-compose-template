package org.mrlem.composesample.features.library.ui.artist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.android.core.feature.ui.StateDelegate
import org.mrlem.android.core.feature.ui.StateProvider
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import javax.inject.Inject

@HiltViewModel
internal class ArtistViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    songRepository: SongRepository,
    artistViewStateConverter: ArtistViewStateConverter,
): ViewModel(),
    StateProvider<ArtistViewState> by StateDelegate(
        ArtistViewState()
) {

    private val artistId = ArtistDestination.Args(savedStateHandle).id

    init {
        viewModelScope.launch {
            val artistWithSongs = checkNotNull(songRepository.getArtist(artistId))
            with(artistViewStateConverter) {
                updateState { artistWithSongs.toViewState() }
            }
        }
    }

}
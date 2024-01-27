package org.mrlem.sample.compose.features.library.ui.artist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.ui.base.BaseViewModel
import org.mrlem.sample.compose.features.library.domain.usecases.GetArtistUseCase
import org.mrlem.sample.compose.features.library.ui.artist.ArtistViewStateConverter.toViewState
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getArtistUseCase: GetArtistUseCase,
): BaseViewModel<ArtistViewState, Unit>(
    initial = ArtistViewState(),
) {

    private val artistId: Int = checkNotNull(savedStateHandle["id"])

    init {
        viewModelScope.launch {
            val artist = checkNotNull(getArtistUseCase(artistId))
            updateState { artist.toViewState() }
        }
    }

}
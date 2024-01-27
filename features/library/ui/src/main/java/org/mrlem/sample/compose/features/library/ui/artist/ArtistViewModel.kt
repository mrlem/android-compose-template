package org.mrlem.sample.compose.features.library.ui.artist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.ui.base.StateDelegate
import org.mrlem.sample.compose.core.ui.base.StateProvider
import org.mrlem.sample.compose.features.library.domain.usecases.GetArtistUseCase
import org.mrlem.sample.compose.features.library.ui.artist.ArtistViewStateConverter.toViewState
import javax.inject.Inject

@HiltViewModel
internal class ArtistViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getArtistUseCase: GetArtistUseCase,
): ViewModel(),
    StateProvider<ArtistViewState> by StateDelegate(ArtistViewState()
) {

    private val artistId: Int = checkNotNull(savedStateHandle["id"])

    init {
        viewModelScope.launch {
            val artist = checkNotNull(getArtistUseCase(artistId))
            updateState { artist.toViewState() }
        }
    }

}
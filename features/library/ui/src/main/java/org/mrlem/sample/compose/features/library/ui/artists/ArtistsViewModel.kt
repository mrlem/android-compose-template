package org.mrlem.sample.compose.features.library.ui.artists

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.feature.ui.EffectsDelegate
import org.mrlem.sample.compose.core.feature.ui.EffectsProvider
import org.mrlem.sample.compose.core.feature.ui.StateDelegate
import org.mrlem.sample.compose.core.feature.ui.StateProvider
import org.mrlem.sample.compose.features.library.domain.usecases.GetArtistsUseCase
import org.mrlem.sample.compose.features.library.nav.LibraryDestination
import org.mrlem.sample.compose.features.library.ui.artists.ArtistsViewStateConverter.toViewState
import javax.inject.Inject

@HiltViewModel
internal class ArtistsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getArtistsUseCase: GetArtistsUseCase,
) : ViewModel(),
    StateProvider<ArtistsViewState> by StateDelegate(ArtistsViewState()),
    EffectsProvider<ArtistsViewEffect> by EffectsDelegate()
{

    private var artistId = LibraryDestination.Args(savedStateHandle).artistId

    init {
        viewModelScope.launch {
            val artists = getArtistsUseCase()
            updateState { copy(items = artists.toViewState()) }
        }
    }

    fun handleRedirections() {
        artistId
            ?.let { viewModelScope.sendEffect(ArtistsViewEffect.GoToArtist(it)) }
        artistId = null
    }

    fun onAction(action: ArtistsViewAction) {
        when (action) {
            is ArtistsViewAction.SelectArtist ->
                viewModelScope.sendEffect(ArtistsViewEffect.GoToArtist(action.artistId))
        }
    }

}
package org.mrlem.sample.compose.features.library.ui.artists

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.ui.base.BaseViewModel
import org.mrlem.sample.compose.features.library.domain.usecases.GetArtistsUseCase
import org.mrlem.sample.compose.features.library.ui.artists.ArtistsViewStateConverter.toViewState
import javax.inject.Inject

@HiltViewModel
internal class ArtistsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getArtistsUseCase: GetArtistsUseCase,
) : BaseViewModel<ArtistsViewState, ArtistsViewEffect>(
    initial = ArtistsViewState(),
) {

    private var artistId: String? = savedStateHandle["artistId"]

    init {
        viewModelScope.launch {
            val artists = getArtistsUseCase()
            updateState { copy(items = artists.toViewState()) }
        }
    }

    fun handleRedirections() {
        artistId
            ?.toIntOrNull()
            ?.let { sendEffect(ArtistsViewEffect.GoToArtist(it)) }
        artistId = null
    }

    fun onAction(action: ArtistsViewAction) {
        when (action) {
            is ArtistsViewAction.SelectArtist ->
                sendEffect(ArtistsViewEffect.GoToArtist(action.artistId))
        }
    }

}
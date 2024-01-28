package org.mrlem.sample.compose.features.library.ui.artists

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.feature.ui.EffectsDelegate
import org.mrlem.sample.compose.core.feature.ui.EffectsProvider
import org.mrlem.sample.compose.core.feature.ui.StateDelegate
import org.mrlem.sample.compose.core.feature.ui.StateProvider
import org.mrlem.sample.compose.features.library.domain.usecases.GetArtistsUseCase
import org.mrlem.sample.compose.features.library.domain.usecases.RefreshArtistsUseCase
import org.mrlem.sample.compose.features.library.nav.LibraryDestination
import org.mrlem.sample.compose.features.library.ui.artists.ArtistsViewStateConverter.toViewState
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class ArtistsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getArtistsUseCase: GetArtistsUseCase,
    private val refreshArtistsUseCase: RefreshArtistsUseCase,
) : ViewModel(),
    StateProvider<ArtistsViewState> by StateDelegate(ArtistsViewState()),
    EffectsProvider<ArtistsViewEffect> by EffectsDelegate()
{

    private var artistId = LibraryDestination.Args(savedStateHandle).artistId
    private val refreshRequested = MutableSharedFlow<Unit>()

    init {
        viewModelScope.launch {
            getArtistsUseCase()
                .collectLatest { artists ->
                    updateState { copy(items = artists.toViewState()) }
                }
        }

        viewModelScope.launch {
            refreshRequested
                .collectLatest {
                    try {
                        refreshArtistsUseCase()
                    } catch (e: Exception) {
                        Timber.e(e, "failed to download new songs")
                        sendEffect(ArtistsViewEffect.ShowError)
                    }
                }
        }
    }

    fun handleRedirections() {
        artistId
            ?.let { viewModelScope.sendEffect(ArtistsViewEffect.GoToArtist(it)) }
        artistId = null // handled
    }

    fun onAction(action: ArtistsViewAction) {
        when (action) {
            is ArtistsViewAction.ArtistClick ->
                viewModelScope.sendEffect(ArtistsViewEffect.GoToArtist(action.artistId))
            is ArtistsViewAction.RefreshClick ->
                viewModelScope.launch { refreshRequested.emit(Unit) }
        }
    }

}
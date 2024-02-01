package org.mrlem.composesample.features.library.ui.artists

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.mrlem.android.core.feature.ui.EffectsDelegate
import org.mrlem.android.core.feature.ui.EffectsProvider
import org.mrlem.android.core.feature.ui.StateDelegate
import org.mrlem.android.core.feature.ui.StateProvider
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import org.mrlem.composesample.features.library.nav.LibraryDestination
import org.mrlem.composesample.features.library.ui.artists.ArtistsViewStateConverter.toViewState
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class ArtistsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val songRepository: SongRepository,
) : ViewModel(),
    StateProvider<ArtistsViewState> by StateDelegate(ArtistsViewState()),
    EffectsProvider<ArtistsViewEffect> by EffectsDelegate()
{

    private var artistId = LibraryDestination.Args(savedStateHandle).artistId
    private val refreshRequested = MutableSharedFlow<Unit>()

    init {
        viewModelScope.launch {
            songRepository.getArtists()
                .collectLatest { artists ->
                    updateState { copy(items = artists.toViewState()) }
                }
        }

        viewModelScope.launch {
            refreshRequested
                .collectLatest {
                    try {
                        songRepository.download()
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
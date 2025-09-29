package org.mrlem.composesample.features.library.ui.artists

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import org.mrlem.composesample.features.library.nav.LibraryDestination
import org.mrlem.composesample.features.library.ui.artists.ArtistsViewStateConverter.toViewState
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class ArtistsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val songRepository: SongRepository,
) : UnidirectionalViewModel<ArtistsViewState, Unit, ArtistsViewEffect>() {

    override val state = MutableStateFlow(ArtistsViewState())

    private var artistId = LibraryDestination.Args(savedStateHandle).artistId
    private val refreshRequested = MutableSharedFlow<Unit>()

    init {
        viewModelScope.launch {
            songRepository.getArtists()
                .collectLatest { artists ->
                    state.update { it.copy(items = artists.toViewState()) }
                }
        }

        viewModelScope.launch {
            refreshRequested
                .collectLatest {
                    try {
                        songRepository.download()
                    } catch (e: Exception) {
                        Timber.e(e, "failed to download new songs")
                        trigger(ArtistsViewEffect.ShowError)
                    }
                }
        }
    }

    fun handleRedirections() {
        artistId
            ?.let { trigger(ArtistsViewEffect.GoToArtist(it)) }
        artistId = null // handled
    }

    fun onAction(action: ArtistsViewAction) {
        when (action) {
            is ArtistsViewAction.ArtistClick ->
                trigger(ArtistsViewEffect.GoToArtist(action.artistId))
            is ArtistsViewAction.RefreshClick ->
                viewModelScope.launch { refreshRequested.emit(Unit) }
        }
    }

}
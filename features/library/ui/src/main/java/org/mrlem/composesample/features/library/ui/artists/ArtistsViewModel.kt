package org.mrlem.composesample.features.library.ui.artists

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import org.mrlem.composesample.features.library.nav.LibraryDestination
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class ArtistsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val songRepository: SongRepository,
    converter: ArtistsViewStateConverter,
) : UnidirectionalViewModel<ArtistsViewState, ArtistsViewAction, ArtistsViewEffect>() {

    override val state = songRepository.getArtists()
        .map { artists -> converter.toViewState(artists) }
        .stateIn(viewModelScope, WhileSubscribed(), ArtistsViewState())

    private var artistId = LibraryDestination.Args(savedStateHandle).artistId

    init {
        actions
            .onEach { action ->
                when (action) {
                    is ArtistsViewAction.ArtistClick -> {
                        trigger(ArtistsViewEffect.GoToArtist(action.artistId))
                    }
                    is ArtistsViewAction.RefreshClick -> {
                        try {
                            songRepository.download()
                        } catch (e: Exception) {
                            Timber.e(e, "failed to download new songs")
                            trigger(ArtistsViewEffect.ShowError)
                        }
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun handleRedirections() {
        artistId
            ?.let { trigger(ArtistsViewEffect.GoToArtist(it)) }
        artistId = null // handled
    }

}
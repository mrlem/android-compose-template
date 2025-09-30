package org.mrlem.composesample.features.library.ui.artist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import javax.inject.Inject

@HiltViewModel
internal class ArtistViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    songRepository: SongRepository,
    converter: ArtistViewStateConverter,
): UnidirectionalViewModel<ArtistViewState, Unit, Unit>() {

    private val artistId = ArtistDestination.Args(savedStateHandle).id

    override val state = flow {
        val (artist, songs) = songRepository.getArtist(artistId)!!
        emit(converter.toViewState(artist, songs))
    }
        .stateIn(viewModelScope, WhileSubscribed(), ArtistViewState())

}
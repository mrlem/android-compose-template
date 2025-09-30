package org.mrlem.composesample.features.spotlight.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import javax.inject.Inject

@HiltViewModel
internal class SpotlightViewModel @Inject constructor(
    private val songRepository: SongRepository,
    converter: SpotlightViewStateConverter,
) : UnidirectionalViewModel<SpotlightViewState, Unit, Unit>() {

    override val state = flow {
        emit(converter.toViewState(songRepository.findArtistIdByName("Muse")!!))
    }
        .stateIn(viewModelScope, WhileSubscribed(), SpotlightViewState())

}
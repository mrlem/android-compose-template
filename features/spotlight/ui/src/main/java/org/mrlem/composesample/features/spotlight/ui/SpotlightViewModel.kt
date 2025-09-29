package org.mrlem.composesample.features.spotlight.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import javax.inject.Inject

@HiltViewModel
class SpotlightViewModel @Inject constructor(
    private val songRepository: SongRepository,
) : UnidirectionalViewModel<SpotlightViewState, Unit, Unit>() {

    override val state = MutableStateFlow(SpotlightViewState())

    init {
        viewModelScope.launch {
            songRepository.findArtistIdByName("Muse")
                ?.let { id -> state.update { it.copy(buttonArtistId = id) } }
        }
    }

}
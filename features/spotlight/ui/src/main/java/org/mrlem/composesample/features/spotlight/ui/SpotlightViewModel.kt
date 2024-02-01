package org.mrlem.composesample.features.spotlight.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.android.core.feature.ui.StateDelegate
import org.mrlem.android.core.feature.ui.StateProvider
import org.mrlem.composesample.features.library.domain.repositories.SongRepository
import javax.inject.Inject

@HiltViewModel
class SpotlightViewModel @Inject constructor(
    private val songRepository: SongRepository,
) : ViewModel(),
    StateProvider<SpotlightViewState> by StateDelegate(SpotlightViewState())
{

    init {
        viewModelScope.launch {
            songRepository.findArtistIdByName("Muse")
                ?.let { updateState { copy(buttonArtistId = it) } }
        }
    }

}
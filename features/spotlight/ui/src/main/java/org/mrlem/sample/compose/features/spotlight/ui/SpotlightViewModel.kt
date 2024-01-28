package org.mrlem.sample.compose.features.spotlight.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.feature.ui.EffectsDelegate
import org.mrlem.sample.compose.core.feature.ui.EffectsProvider
import org.mrlem.sample.compose.features.library.domain.repositories.SongRepository
import javax.inject.Inject

@HiltViewModel
class SpotlightViewModel @Inject constructor(
    private val songRepository: SongRepository,
) : ViewModel(),
    EffectsProvider<SpotlightViewEffect> by EffectsDelegate()
{

    fun onAction(action: SpotlightViewAction) =
        when (action) {
            is SpotlightViewAction.ButtonClick -> {
                viewModelScope.launch {
                    songRepository.findArtistIdByName("Muse")
                        ?.let { sendEffect(SpotlightViewEffect.GoToArtist(it)) }
                }
            }
        }
}
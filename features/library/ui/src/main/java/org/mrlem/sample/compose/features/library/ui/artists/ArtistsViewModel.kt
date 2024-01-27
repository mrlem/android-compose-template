package org.mrlem.sample.compose.features.library.ui.artists

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.ui.base.BaseViewModel
import org.mrlem.sample.compose.features.library.domain.usecases.GetArtistsUseCase
import org.mrlem.sample.compose.features.library.ui.artists.ArtistsViewStateConverter.toViewState
import javax.inject.Inject

@HiltViewModel
class ArtistsViewModel @Inject constructor(
    getArtistsUseCase: GetArtistsUseCase,
) : BaseViewModel<ArtistsViewState>(
    initial = ArtistsViewState(),
) {

    init {
        viewModelScope.launch {
            val artists = getArtistsUseCase()
            updateState { copy(items = artists.toViewState()) }
        }
    }

}
package org.mrlem.sample.compose.features.library.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.ui.base.BaseViewModel
import org.mrlem.sample.compose.features.library.domain.usecases.GetArtistsUseCase
import org.mrlem.sample.compose.features.library.ui.LibraryViewStateConverter.toViewState
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    getArtistsUseCase: GetArtistsUseCase,
) : BaseViewModel<LibraryViewState>(
    initial = LibraryViewState(),
) {

    init {
        viewModelScope.launch {
            val artists = getArtistsUseCase()
            updateState { copy(items = artists.toViewState()) }
        }
    }

}
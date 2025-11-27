package org.mrlem.composesample.features.library.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.BookmarkRepository
import javax.inject.Inject

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: BookmarkRepository,
    converter: DetailViewStateConverter,
) : UnidirectionalViewModel<DetailViewState, Unit, Unit>() {

    private val id = DetailDestination.Args(savedStateHandle).id

    override val state = flow {
        emit(converter.toViewState(bookmark = repository.get(id)))
    }
        .stateIn(viewModelScope, WhileSubscribed(), DetailViewState())
}
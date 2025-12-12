package org.mrlem.composesample.features.library.ui.detail

import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.BookmarkRepository
import org.mrlem.composesample.features.library.nav.BookmarkKey

@HiltViewModel(assistedFactory = DetailViewModel.Factory::class)
internal class DetailViewModel @AssistedInject constructor(
    repository: BookmarkRepository,
    converter: DetailViewStateConverter,
    @Assisted key: BookmarkKey,
) : UnidirectionalViewModel<DetailViewState, Unit, Unit>() {

    @AssistedFactory
    interface Factory {
        fun create(navKey: BookmarkKey): DetailViewModel
    }

    override val state = flow {
        emit(converter.toViewState(bookmark = repository.get(key.itemId)))
    }
        .stateIn(viewModelScope, WhileSubscribed(), DetailViewState())
}
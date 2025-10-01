package org.mrlem.composesample.features.library.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.BookmarkRepository
import org.mrlem.composesample.features.library.domain.usecase.ImportRandomBookmark
import org.mrlem.composesample.features.library.nav.LibraryDestination
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class ListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: BookmarkRepository,
    importRandomBookmark: ImportRandomBookmark,
    converter: ListViewStateConverter,
) : UnidirectionalViewModel<ListViewState, ListViewAction, ListViewEffect>() {

    override val state = repository.bookmarks
        .map { items -> converter.toViewState(items) }
        .stateIn(viewModelScope, WhileSubscribed(), ListViewState())

    private var itemId = LibraryDestination.Args(savedStateHandle).itemId

    init {
        actions
            .onEach { action ->
                when (action) {
                    is ListViewAction.ItemClick -> {
                        trigger(ListViewEffect.GoToItem(action.itemId))
                    }
                    is ListViewAction.ImportRandomClick -> {
                        try {
                            importRandomBookmark()
                        } catch (e: Exception) {
                            Timber.e(e, "failed to import new bookmark")
                            trigger(ListViewEffect.ShowError)
                        }
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun handleRedirections() {
        itemId
            ?.let { trigger(ListViewEffect.GoToItem(it)) }
        itemId = null // handled
    }

}
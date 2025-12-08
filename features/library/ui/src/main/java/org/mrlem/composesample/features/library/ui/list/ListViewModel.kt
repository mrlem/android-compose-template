package org.mrlem.composesample.features.library.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.repositories.BookmarkRepository
import org.mrlem.composesample.features.library.domain.usecase.ImportRandomBookmark
import org.mrlem.composesample.features.library.nav.LibraryDestination
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
@OptIn(SavedStateHandleSaveableApi::class)
internal class ListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: BookmarkRepository,
    importRandomBookmark: ImportRandomBookmark,
    converter: ListViewStateConverter,
) : UnidirectionalViewModel<ListViewState, ListViewAction, ListViewEffect>() {

    private var filterFlow = savedStateHandle.getMutableStateFlow("filter", "")

    override val state = combine(repository.bookmarks, filterFlow) { items, filter ->
        converter.toViewState(
            filter = filter,
            items = items.filter { it.name.contains(filter, ignoreCase = true) },
        )
    }
        .stateIn(viewModelScope, WhileSubscribed(), ListViewState(filter = filterFlow.value))

    private var itemId = LibraryDestination.Args(savedStateHandle).itemId

    init {
        actions
            .onEach { action ->
                when (action) {
                    is ListViewAction.ItemClick -> {
                        trigger(ListViewEffect.GoToItem(action.itemId))
                    }

                    is ListViewAction.ItemDismiss -> {
                        viewModelScope.launch {
                            try {
                                repository.delete(action.itemId)
                            } catch (e: IOException) {
                                Timber.e(e, "failed to remove bookmark")
                                trigger(ListViewEffect.ShowError)
                            }
                        }
                    }

                    is ListViewAction.ImportRandomClick -> {
                        try {
                            importRandomBookmark()
                        } catch (e: IOException) {
                            Timber.e(e, "failed to import new bookmark")
                            trigger(ListViewEffect.ShowError)
                        }
                    }

                    is ListViewAction.FilterChange -> {
                        filterFlow.value = action.value
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
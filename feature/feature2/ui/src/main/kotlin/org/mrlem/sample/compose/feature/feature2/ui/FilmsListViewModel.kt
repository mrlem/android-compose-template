package org.mrlem.sample.compose.feature.feature2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.domain.Loadable
import org.mrlem.sample.compose.arch.ui.StateDelegate
import org.mrlem.sample.compose.arch.ui.StateProvider
import org.mrlem.sample.compose.feature.feature2.domain.repository.GhibliRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
internal class FilmsListViewModel @Inject constructor(
    private val repository: GhibliRepository,
) : ViewModel(),
    StateProvider<FilmsListViewState> by StateDelegate(FilmsListViewState()) {

    init {
        viewModelScope.launch {
            repository.listFilms()
                .collect { filmsLoadable ->
                    when (filmsLoadable) {
                        is Loadable.Loading -> {
                            Timber.i("films: loading")
                        }
                        is Loadable.Success -> {
                            val films = filmsLoadable.data
                            Timber.i("films: ${films.size}")
                            updateState { copy(films = films) }
                        }
                    }
                }
        }
    }

    fun refresh() {
        updateState { copy(isRefreshing = true) }
        viewModelScope.launch {
            repository.refresh()
            updateState { copy(isRefreshing = false) }
        }
    }

}
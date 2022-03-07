package org.mrlem.sample.compose.feature.filmslist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.ui.StateDelegate
import org.mrlem.sample.compose.arch.ui.StateProvider
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import javax.inject.Inject

@HiltViewModel
class FilmsListViewModel @Inject constructor(
    ghibliRepository: GhibliRepository,
) : ViewModel(),
    StateProvider<FilmsListState> by StateDelegate(FilmsListState()) {

    init {
        viewModelScope.launch {
            val films = ghibliRepository.listFilms()
            updateState { copy(
                films = films,
            ) }
        }
    }

}
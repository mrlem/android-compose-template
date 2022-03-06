package org.mrlem.sample.compose.feature.filmslist.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.mrlem.sample.compose.arch.ui.StateDelegate
import org.mrlem.sample.compose.arch.ui.StateProvider
import javax.inject.Inject

@HiltViewModel
class FilmsListViewModel @Inject constructor(
) : ViewModel(),
    StateProvider<FilmsListState> by StateDelegate(FilmsListState()) {

    fun incrementCounter() {}

}
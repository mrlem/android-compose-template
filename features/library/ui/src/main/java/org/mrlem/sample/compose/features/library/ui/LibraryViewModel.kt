package org.mrlem.sample.compose.features.library.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.ui.base.BaseViewModel
import org.mrlem.sample.compose.features.library.domain.usecases.SayHelloUseCase
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    sayHelloUseCase: SayHelloUseCase,
) : BaseViewModel<LibraryViewState>(
    initial = LibraryViewState(),
) {

    init {
        viewModelScope.launch {
            val label = sayHelloUseCase()
            updateState { copy(label = label) }
        }
    }

}
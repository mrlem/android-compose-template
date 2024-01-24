package org.mrlem.sample.compose.features.home.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.core.ui.base.BaseViewModel
import org.mrlem.sample.compose.features.home.domain.SayHelloUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    sayHelloUseCase: SayHelloUseCase,
) : BaseViewModel<HomeViewState>(
    initial = HomeViewState(),
) {

    init {
        viewModelScope.launch {
            val label = sayHelloUseCase()
            updateState { copy(label = label) }
        }
    }

}
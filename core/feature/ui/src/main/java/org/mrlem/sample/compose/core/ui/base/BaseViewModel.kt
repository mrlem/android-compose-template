package org.mrlem.sample.compose.core.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<ViewState>(
    initial: ViewState,
) : ViewModel() {

    private val _state = MutableStateFlow(initial)
    val state: StateFlow<ViewState> = _state

    protected fun updateState(updater: ViewState.() -> ViewState) {
        _state.value = _state.value.updater()
    }

}
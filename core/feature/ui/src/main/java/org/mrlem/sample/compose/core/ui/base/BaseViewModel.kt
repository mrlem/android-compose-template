package org.mrlem.sample.compose.core.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<ViewState, ViewEffect>(
    initial: ViewState,
) : ViewModel() {

    private val _state = MutableStateFlow(initial)
    val state: StateFlow<ViewState> = _state

    private val _effects = MutableSharedFlow<ViewEffect>()
    val effects: Flow<ViewEffect> = _effects

    protected fun updateState(updater: ViewState.() -> ViewState) {
        _state.value = _state.value.updater()
    }

    protected fun sendEffect(effect: ViewEffect) {
        viewModelScope.launch {
            _effects.emit(effect)
        }
    }

}
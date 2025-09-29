package org.mrlem.android.core.feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class UnidirectionalViewModel<State : Any, Action: Any, Effect : Any> : ViewModel() {

    abstract val state: StateFlow<State>

    protected val actions = MutableSharedFlow<Action>()

    private val _effects = MutableSharedFlow<Effect>()
    val effects = _effects.asSharedFlow()

    fun onAction(action: Action) {
        viewModelScope.launch(Dispatchers.Main.immediate) {
            actions.emit(action)
        }
    }

    protected fun trigger(effect: Effect) {
        viewModelScope.launch(Dispatchers.Default) {
            _effects.emit(effect)
        }
    }

}
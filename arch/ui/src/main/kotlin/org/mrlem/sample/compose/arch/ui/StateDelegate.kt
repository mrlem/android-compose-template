package org.mrlem.sample.compose.arch.ui

import androidx.compose.runtime.mutableStateOf

class StateDelegate<S : Any>(
    initialState: S,
) : StateProvider<S> {

    override val state = mutableStateOf(initialState)

    override fun updateState(doUpdate: S.() -> S) {
        state.value = state.value.doUpdate()
    }

}
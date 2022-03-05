package org.mrlem.sample.compose.arch.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class StateDelegate<S : Any>(
    initialState: S,
) : StateProvider<S> {

    override var state by mutableStateOf(initialState)

    override fun updateState(doUpdate: S.() -> S) {
        state = state.doUpdate()
    }

}
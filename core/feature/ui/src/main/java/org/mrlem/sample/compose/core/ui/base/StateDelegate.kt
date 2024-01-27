package org.mrlem.sample.compose.core.ui.base

import kotlinx.coroutines.flow.MutableStateFlow

class StateDelegate<S : Any>(
    initial: S,
) : StateProvider<S> {

    override val state = MutableStateFlow(initial)

    override fun updateState(doUpdate: S.() -> S) {
        state.value = state.value.doUpdate()
    }

}
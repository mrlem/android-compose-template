package org.mrlem.android.core.feature.ui

import kotlinx.coroutines.flow.MutableStateFlow

class StateDelegate<S : Any>(
    initial: S,
) : StateProvider<S> {

    override val state = MutableStateFlow(initial)

    override fun updateState(doUpdate: S.() -> S) {
        state.value = state.value.doUpdate()
    }

}
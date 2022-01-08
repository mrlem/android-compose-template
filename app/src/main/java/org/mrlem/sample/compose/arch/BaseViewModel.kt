package org.mrlem.sample.compose.arch

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class BaseViewModel<S>(
    initialState: S,
) : ViewModel() {

    val state = mutableStateOf(initialState)

    fun updateState(doUpdate: S.() -> S) {
        state.value = state.value.doUpdate()
    }
}
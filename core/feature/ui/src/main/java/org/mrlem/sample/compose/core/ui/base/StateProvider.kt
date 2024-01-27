package org.mrlem.sample.compose.core.ui.base

import kotlinx.coroutines.flow.StateFlow

interface StateProvider<S : Any> {

    val state: StateFlow<S>

    fun updateState(doUpdate: S.() -> S)

}
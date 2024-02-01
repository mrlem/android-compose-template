package org.mrlem.android.core.feature.ui

import kotlinx.coroutines.flow.StateFlow

interface StateProvider<S : Any> {

    val state: StateFlow<S>

    fun updateState(doUpdate: S.() -> S)

}
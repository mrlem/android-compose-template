package org.mrlem.sample.compose.arch.ui

import androidx.compose.runtime.MutableState

interface StateProvider<S : Any> {

    val state: MutableState<S>

    fun updateState(doUpdate: S.() -> S)

}
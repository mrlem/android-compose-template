package org.mrlem.sample.compose.arch.ui

interface StateProvider<S : Any> {

    var state: S

    fun updateState(doUpdate: S.() -> S)

}
package org.mrlem.sample.compose.arch.domain

sealed class Loadable<D> {

    class Loading<D> : Loadable<D>()
    data class Success<D>(val data: D) : Loadable<D>()

}
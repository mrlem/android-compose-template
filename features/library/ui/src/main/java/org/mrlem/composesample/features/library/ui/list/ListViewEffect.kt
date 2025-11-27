package org.mrlem.composesample.features.library.ui.list

internal sealed interface ListViewEffect {

    data class GoToItem(
        val id: Long,
    ) : ListViewEffect

    data object ShowError : ListViewEffect
}
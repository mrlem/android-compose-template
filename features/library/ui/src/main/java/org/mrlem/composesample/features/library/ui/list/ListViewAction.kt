package org.mrlem.composesample.features.library.ui.list

internal sealed interface ListViewAction {

    data class ItemClick(
        val itemId: Long,
    ) : ListViewAction

    data object ImportRandomClick : ListViewAction

    data class FilterChange(
        val value: String,
    ) : ListViewAction
}
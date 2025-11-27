package org.mrlem.composesample.features.library.ui.list

import org.mrlem.composesample.features.library.domain.model.BookmarkItem
import javax.inject.Inject

internal class ListViewStateConverter @Inject constructor() {

    fun toViewState(
        filter: String,
        items: List<BookmarkItem>,
    ) = ListViewState(
        filter = filter,
        items = items.map { it.toViewState() },
    )

    private fun BookmarkItem.toViewState() =
        ListItemViewState<ListViewAction>(
            label = name,
            onClickAction = ListViewAction.ItemClick(id),
        )
}
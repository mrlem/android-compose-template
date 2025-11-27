package org.mrlem.composesample.features.library.ui.list

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mrlem.composesample.features.library.domain.model.BookmarkItem

class ListViewStateConverterTest {

    private val converter = ListViewStateConverter()

    @Test
    fun `test conversion from bookmark items to view state`() {
        // Given
        val filter = "test filter"
        val items = listOf(
            BookmarkItem(id = 1, name = "Item 1"),
            BookmarkItem(id = 2, name = "Item 2"),
        )

        // When
        val viewState = converter.toViewState(filter, items)

        // Then
        assertEquals("test filter", viewState.filter)
        assertEquals(2, viewState.items.size)
        assertEquals("Item 1", viewState.items[0].label)
        assertEquals(ListViewAction.ItemClick(1), viewState.items[0].onClickAction)
        assertEquals("Item 2", viewState.items[1].label)
        assertEquals(ListViewAction.ItemClick(2), viewState.items[1].onClickAction)
    }
}

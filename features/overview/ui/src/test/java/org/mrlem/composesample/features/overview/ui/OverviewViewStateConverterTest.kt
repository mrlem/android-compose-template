package org.mrlem.composesample.features.overview.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.mrlem.composesample.features.library.domain.model.Bookmark

class OverviewViewStateConverterTest {

    private val converter = OverviewViewStateConverter()

    @Test
    fun `test conversion when bookmark is not null`() {
        // Given
        val bookmark = Bookmark(
            id = 123,
            name = "Android",
            description = "Android OS",
            image = "image.url",
        )

        // When
        val viewState = converter.toViewState(bookmark)

        // Then
        assertEquals("Android", viewState.suggestionName)
        assertEquals("image.url", viewState.suggestionImage)
        assertEquals(123L, viewState.suggestionId)
    }

    @Test
    fun `test conversion when bookmark is null`() {
        // When
        val viewState = converter.toViewState(null)

        // Then
        assertNull(viewState.suggestionName)
        assertNull(viewState.suggestionImage)
        assertNull(viewState.suggestionId)
    }
}

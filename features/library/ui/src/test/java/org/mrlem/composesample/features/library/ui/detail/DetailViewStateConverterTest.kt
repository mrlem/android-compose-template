package org.mrlem.composesample.features.library.ui.detail

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mrlem.composesample.features.library.domain.model.Bookmark

class DetailViewStateConverterTest {

    private val converter = DetailViewStateConverter()

    @Test
    fun `test conversion from bookmark to view state`() {
        // Given
        val bookmark = Bookmark(
            id = 42,
            name = "Test Bookmark",
            description = "This is a test bookmark.",
            image = "https://example.com/image.jpg",
        )

        // When
        val viewState = converter.toViewState(bookmark)

        // Then
        assertEquals("Test Bookmark", viewState.name)
        assertEquals("This is a test bookmark.", viewState.description)
        assertEquals("https://example.com/image.jpg", viewState.image)
    }
}

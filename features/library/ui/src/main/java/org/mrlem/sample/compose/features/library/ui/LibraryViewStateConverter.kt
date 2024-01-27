package org.mrlem.sample.compose.features.library.ui

import org.mrlem.sample.compose.features.library.domain.model.Artist

object LibraryViewStateConverter {

    fun List<Artist>.toViewState() =
        map { it.toViewState() }
    fun Artist.toViewState() =
        ItemViewState(
            label = name,
            description = "$songCount songs", // TODO - use plural string
        )

}
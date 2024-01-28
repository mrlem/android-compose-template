package org.mrlem.sample.compose.features.library.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.sample.compose.core.feature.nav.Destination
import org.mrlem.sample.compose.core.feature.nav.DestinationDefinition

private const val libraryRoute = "library"
private const val artistIdArg = "artistId"

data class LibraryDestination(val artistId: Int) : Destination {

    companion object : DestinationDefinition(
        route = "$libraryRoute?$artistIdArg={$artistIdArg}",
        args = listOf(
            navArgument(artistIdArg) {
                type = NavType.StringType
                nullable = true
            }
        ),
    )

    data class Args(
        val artistId: Int?,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            artistId = savedStateHandle.get<String>(artistIdArg)?.toIntOrNull(),
        )

    }

    override fun toString() =
        "$libraryRoute?artistId=$artistId"

}
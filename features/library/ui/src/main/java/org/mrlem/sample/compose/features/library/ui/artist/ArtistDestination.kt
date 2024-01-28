package org.mrlem.sample.compose.features.library.ui.artist

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.sample.compose.core.feature.nav.Destination
import org.mrlem.sample.compose.core.feature.nav.DestinationDefinition

private const val artistRoute = "artist"
private const val artistIdArg = "id"

data class ArtistDestination(
    val artistId: Int,
) : Destination {

    companion object : DestinationDefinition(
        route = "$artistRoute/{$artistIdArg}",
        args = listOf(
            navArgument(artistIdArg) {
                type = NavType.IntType
            }
        ),
    )

    data class Args(
        val id: Int,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            id = checkNotNull(savedStateHandle.get<Int>(artistIdArg)),
        )

    }

    override fun toString() =
        "$artistRoute/$artistId"

}
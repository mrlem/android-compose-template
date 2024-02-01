package org.mrlem.composesample.features.library.ui.artist

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.android.core.feature.nav.Destination
import org.mrlem.android.core.feature.nav.DestinationDefinition

private const val artistRoute = "artist"
private const val artistIdArg = "id"

data class ArtistDestination(
    val artistId: Long,
) : Destination {

    companion object : DestinationDefinition(
        route = "$artistRoute/{$artistIdArg}",
        args = listOf(
            navArgument(artistIdArg) {
                type = NavType.LongType
            }
        ),
    )

    data class Args(
        val id: Long,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            id = checkNotNull(savedStateHandle.get<Long>(artistIdArg)),
        )

    }

    override fun toString() =
        "$artistRoute/$artistId"

}
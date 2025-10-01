package org.mrlem.composesample.features.library.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.android.core.feature.nav.Destination
import org.mrlem.android.core.feature.nav.DestinationDefinition

private const val routeName = "library"
private const val itemIdArg = "itemId"

data class LibraryDestination(
    val itemId: Long,
) : Destination {

    companion object : DestinationDefinition(
        route = "$routeName?$itemIdArg={$itemIdArg}",
        args = listOf(
            navArgument(itemIdArg) {
                type = NavType.StringType
                nullable = true
            }
        ),
    )

    data class Args(
        val itemId: Long?,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            itemId = savedStateHandle
                .get<String>(itemIdArg)
                ?.toLongOrNull(),
        )

    }

    override fun toString() =
        "$routeName?$itemIdArg=$itemId"

}
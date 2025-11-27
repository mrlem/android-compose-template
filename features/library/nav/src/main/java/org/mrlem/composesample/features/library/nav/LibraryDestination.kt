package org.mrlem.composesample.features.library.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.android.core.feature.nav.Destination
import org.mrlem.android.core.feature.nav.DestinationDefinition

private const val ROUTE_NAME = "library"
private const val ITEM_ID_ARG = "itemId"

data class LibraryDestination(
    val itemId: Long,
) : Destination {

    companion object : DestinationDefinition(
        route = "$ROUTE_NAME?$ITEM_ID_ARG={$ITEM_ID_ARG}",
        args = listOf(
            navArgument(ITEM_ID_ARG) {
                type = NavType.StringType
                nullable = true
            },
        ),
    )

    data class Args(
        val itemId: Long?,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            itemId = savedStateHandle
                .get<String>(ITEM_ID_ARG)
                ?.toLongOrNull(),
        )
    }

    override fun toString() = "$ROUTE_NAME?$ITEM_ID_ARG=$itemId"
}
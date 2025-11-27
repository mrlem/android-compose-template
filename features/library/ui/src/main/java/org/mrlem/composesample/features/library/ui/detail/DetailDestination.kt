package org.mrlem.composesample.features.library.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.android.core.feature.nav.Destination
import org.mrlem.android.core.feature.nav.DestinationDefinition

private const val ROUTE_NAME = "detail"
private const val ID_ARG = "id"

data class DetailDestination(
    val id: Long,
) : Destination {

    companion object : DestinationDefinition(
        route = "$ROUTE_NAME/{$ID_ARG}",
        args = listOf(
            navArgument(ID_ARG) {
                type = NavType.LongType
            },
        ),
    )

    data class Args(
        val id: Long,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            id = savedStateHandle.get<Long>(ID_ARG)!!,
        )
    }

    override fun toString() = "$ROUTE_NAME/$id"
}
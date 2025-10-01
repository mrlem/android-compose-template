package org.mrlem.composesample.features.library.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.android.core.feature.nav.Destination
import org.mrlem.android.core.feature.nav.DestinationDefinition

private const val routeName = "detail"
private const val idArg = "id"

data class DetailDestination(
    val id: Long,
) : Destination {

    companion object : DestinationDefinition(
        route = "$routeName/{$idArg}",
        args = listOf(
            navArgument(idArg) {
                type = NavType.LongType
            }
        ),
    )

    data class Args(
        val id: Long,
    ) {

        constructor(savedStateHandle: SavedStateHandle) : this(
            id = savedStateHandle.get<Long>(idArg)!!,
        )

    }

    override fun toString() =
        "$routeName/$id"

}
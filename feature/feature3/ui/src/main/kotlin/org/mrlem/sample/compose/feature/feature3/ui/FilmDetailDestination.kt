package org.mrlem.sample.compose.feature.feature3.ui

import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.sample.compose.arch.ui.Destination

object FilmDetailDestination : Destination(
    route = "film/{id}",
    args = listOf(
        navArgument(FilmDetailViewModel.STATE_ID) {
            type = NavType.StringType
            nullable = false
        }
    ),
) {

    fun route(id: String) = "film/$id"

}
package org.mrlem.sample.compose

import androidx.navigation.NavType
import androidx.navigation.navArgument
import org.mrlem.sample.compose.feature.filmdetail.ui.FilmDetailViewModel

sealed class Screens(val route: String) {

    object Films : Screens("films")

    object FilmDetail : Screens("film/{id}") {
        val args = listOf(
            navArgument(FilmDetailViewModel.STATE_ID) {
                type = NavType.StringType
                nullable = false
            }
        )
        fun with(id: String) = "film/$id"
    }

}
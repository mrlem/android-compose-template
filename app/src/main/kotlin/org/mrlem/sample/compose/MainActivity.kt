package org.mrlem.sample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.feature.filmdetail.ui.FilmDetailScreen
import org.mrlem.sample.compose.feature.filmslist.ui.FilmsListScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Films.route,
                    ) {
                        composable(
                            route = Screens.Films.route,
                        ) {
                            FilmsListScreen(
                                navigateToFilm = { id -> navController.navigate("film/$id") },
                            )
                        }
                        composable(
                            route = Screens.FilmDetail.route,
                            arguments = listOf(
                                navArgument("id") {
                                    type = NavType.StringType
                                    nullable = false
                                }
                            ),
                        ) {
                            FilmDetailScreen(
                                id = it.arguments?.getString("id").orEmpty(),
                                navigateToHome = { navController.navigate(Screens.Films.route) },
                            )
                        }
                    }

                }
            }
        }
    }

}
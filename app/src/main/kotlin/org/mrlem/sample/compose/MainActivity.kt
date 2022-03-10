package org.mrlem.sample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.feature.filmdetail.ui.FilmDetailScreen
import org.mrlem.sample.compose.feature.filmslist.ui.FilmsListScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private const val TRANSITION_DURATION = 250
    }

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
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
                            enterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(TRANSITION_DURATION)) },
                            exitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(TRANSITION_DURATION)) },
                            popEnterTransition = { slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(TRANSITION_DURATION)) },
                            popExitTransition = { slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(TRANSITION_DURATION)) },
                        ) {
                            FilmDetailScreen(
                                id = it.arguments?.getString("id").orEmpty(),
                                navigateToHome = { navController.navigateUp() },
                            )
                        }
                    }
                }
            }
        }
    }

}
package org.mrlem.sample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope.SlideDirection
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import org.mrlem.sample.compose.arch.ui.composable
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.feature.feature2.ui.FilmsListDestination
import org.mrlem.sample.compose.feature.feature2.ui.FilmsListScreen
import org.mrlem.sample.compose.feature.feature3.ui.FilmDetailDestination
import org.mrlem.sample.compose.feature.feature3.ui.FilmDetailScreen

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
                        startDestination = FilmsListDestination.route,
                    ) {
                        composable(
                            destination = FilmsListDestination,
                        ) {
                            FilmsListScreen(
                                navigateToFilm = { id -> navController.navigate(FilmDetailDestination.route(id)) },
                            )
                        }
                        composable(
                            destination = FilmDetailDestination,
                            enterTransition = { slideIntoContainer(SlideDirection.Left, animationSpec = tween(TRANSITION_DURATION)) },
                            exitTransition = { slideOutOfContainer(SlideDirection.Left, animationSpec = tween(TRANSITION_DURATION)) },
                            popEnterTransition = { slideIntoContainer(SlideDirection.Right, animationSpec = tween(TRANSITION_DURATION)) },
                            popExitTransition = { slideOutOfContainer(SlideDirection.Right, animationSpec = tween(TRANSITION_DURATION)) },
                        ) {
                            FilmDetailScreen(
                                navigateToHome = { navController.navigateUp() },
                            )
                        }
                    }
                }
            }
        }
    }

}
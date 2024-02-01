package org.mrlem.composesample.features.library.ui

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.mrlem.android.core.feature.nav.navigate
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.composesample.features.library.nav.LibraryDestination
import org.mrlem.composesample.features.library.ui.artist.ArtistDestination
import org.mrlem.composesample.features.library.ui.artist.ArtistScreen
import org.mrlem.composesample.features.library.ui.artists.ArtistsDestination
import org.mrlem.composesample.features.library.ui.artists.ArtistsScreen
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryNavigationProvider @Inject constructor() : NavProvider {

    override fun graph(builder: NavGraphBuilder, navController: NavController, snackbarHostState: SnackbarHostState) =
        builder.run {
            navigation(
                startDestination = ArtistsDestination.route,
                route = LibraryDestination.route,
                arguments = LibraryDestination.args,
            ) {
                composable(
                    route = ArtistsDestination.route,
                ) {
                    ArtistsScreen(
                        snackbarHostState = snackbarHostState,
                        onArtistSelect = { id -> navController.navigate(ArtistDestination(id)) },
                    )
                }
                composable(
                    route = ArtistDestination.route,
                    arguments = ArtistDestination.args,
                ) {
                    ArtistScreen()
                }
            }
        }

}
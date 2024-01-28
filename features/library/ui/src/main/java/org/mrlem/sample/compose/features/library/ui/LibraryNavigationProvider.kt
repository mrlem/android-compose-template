package org.mrlem.sample.compose.features.library.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.mrlem.sample.compose.core.feature.nav.navigate
import org.mrlem.sample.compose.core.feature.ui.NavProvider
import org.mrlem.sample.compose.features.library.nav.LibraryDestination
import org.mrlem.sample.compose.features.library.ui.artist.ArtistDestination
import org.mrlem.sample.compose.features.library.ui.artist.ArtistScreen
import org.mrlem.sample.compose.features.library.ui.artists.ArtistsDestination
import org.mrlem.sample.compose.features.library.ui.artists.ArtistsScreen
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryNavigationProvider @Inject constructor() : NavProvider {

    override fun graph(builder: NavGraphBuilder, navController: NavController) =
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
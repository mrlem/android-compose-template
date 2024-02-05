package org.mrlem.composesample.features.spotlight.ui

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.android.core.feature.nav.navigate
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.composesample.features.library.nav.LibraryDestination
import org.mrlem.composesample.features.spotlight.nav.SpotlightDestination
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SpotlightNavProvider @Inject constructor() : NavProvider {

    override fun graph(builder: NavGraphBuilder, navController: NavController, snackbarHostState: SnackbarHostState) = builder.run {
        composable(SpotlightDestination.route) {
            SpotlightScreen(
                onSuggestionClick = { artistId ->
                    navController.navigate(LibraryDestination(artistId = artistId)) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                },
            )
        }
    }

}
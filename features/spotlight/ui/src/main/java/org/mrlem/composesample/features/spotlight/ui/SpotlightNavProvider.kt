package org.mrlem.composesample.features.spotlight.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.android.core.feature.nav.Navigator
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.composesample.features.library.nav.LibraryDestination
import org.mrlem.composesample.features.spotlight.nav.R
import org.mrlem.composesample.features.spotlight.nav.SpotlightDestination
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SpotlightNavProvider @Inject constructor(
    private val navigator: Navigator,
) : NavProvider {

    override val navBarItem = NavProvider.BottomBarItem(
        index = 0,
        labelResId = R.string.spotlight_bottomnav_label,
        icon = Icons.Filled.Info,
        route = SpotlightDestination.route,
        isStart = true,
    )

    override fun graph(builder: NavGraphBuilder, snackbarHostState: SnackbarHostState) = builder.run {
        composable(SpotlightDestination.route) {
            SpotlightScreen(
                onSuggestionClick = { artistId ->
                    navigator.navigate(LibraryDestination(artistId = artistId)) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                },
            )
        }
    }

}
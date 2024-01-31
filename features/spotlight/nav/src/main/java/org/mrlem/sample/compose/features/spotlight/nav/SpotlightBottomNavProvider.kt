package org.mrlem.sample.compose.features.spotlight.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import org.mrlem.sample.compose.core.feature.nav.BottomNavProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SpotlightBottomNavProvider @Inject constructor() : BottomNavProvider {

    override val navBarItem = BottomNavProvider.Item(
        index = 0,
        label = "Spotlight",
        icon = Icons.Filled.Info,
        route = SpotlightDestination.route,
    )

}
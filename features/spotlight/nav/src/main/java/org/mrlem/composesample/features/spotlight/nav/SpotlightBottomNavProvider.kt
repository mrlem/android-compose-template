package org.mrlem.composesample.features.spotlight.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import org.mrlem.android.core.feature.nav.BottomNavProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SpotlightBottomNavProvider @Inject constructor() : BottomNavProvider {

    override val navBarItem = BottomNavProvider.Item(
        index = 0,
        labelResId = R.string.spotlight_bottomnav_label,
        icon = Icons.Filled.Info,
        route = SpotlightDestination.route,
    )

}
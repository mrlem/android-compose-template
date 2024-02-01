package org.mrlem.sample.compose.features.library.ui.artists

import org.mrlem.android.core.feature.nav.Destination
import org.mrlem.android.core.feature.nav.DestinationDefinition

object ArtistsDestination : Destination,
    DestinationDefinition(
        route = "artists",
    )
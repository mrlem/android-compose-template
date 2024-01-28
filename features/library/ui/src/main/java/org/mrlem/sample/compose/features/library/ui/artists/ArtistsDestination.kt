package org.mrlem.sample.compose.features.library.ui.artists

import org.mrlem.sample.compose.core.feature.nav.Destination
import org.mrlem.sample.compose.core.feature.nav.DestinationDefinition

object ArtistsDestination : Destination,
    DestinationDefinition(
        route = "artists",
    )
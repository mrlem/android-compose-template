package org.mrlem.sample.compose.features.spotlight.nav

import org.mrlem.sample.compose.core.feature.nav.Destination
import org.mrlem.sample.compose.core.feature.nav.DestinationDefinition

object SpotlightDestination : Destination,
    DestinationDefinition(
        route = "spotlight",
    )
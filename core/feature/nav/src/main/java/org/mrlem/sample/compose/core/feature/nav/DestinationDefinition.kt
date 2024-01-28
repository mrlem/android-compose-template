package org.mrlem.sample.compose.core.feature.nav

import androidx.navigation.NamedNavArgument

open class DestinationDefinition(
    val route: String,
    val args: List<NamedNavArgument> = emptyList(),
) {

    override fun toString() = route

}
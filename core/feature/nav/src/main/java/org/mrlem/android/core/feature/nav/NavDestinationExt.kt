package org.mrlem.android.core.feature.nav

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

fun NavDestination.belongsTo(route: String) =
    hierarchy
        .any { it.route.withoutArgs == route.withoutArgs }

private val String?.withoutArgs
    get() = this?.split('?')?.firstOrNull()
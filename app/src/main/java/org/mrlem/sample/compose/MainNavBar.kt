package org.mrlem.sample.compose

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import org.mrlem.sample.compose.core.feature.nav.BottomNavProvider

@Composable
fun MainNavBar(
    items: List<BottomNavProvider.Item>,
    navController: NavController,
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.label) },
                selected = currentDestination?.hierarchy?.any {
                    it.route?.split('?')?.firstOrNull() == item.route
                } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
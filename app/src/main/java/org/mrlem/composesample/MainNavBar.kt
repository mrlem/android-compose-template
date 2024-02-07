package org.mrlem.composesample

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.mrlem.android.core.feature.nav.belongsTo
import org.mrlem.android.core.feature.ui.NavProvider

@Composable
fun MainNavBar(
    items: List<NavProvider.BottomBarItem>,
    navController: NavController,
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(stringResource(item.labelResId)) },
                selected = currentDestination?.belongsTo(item.route) ?: false,
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
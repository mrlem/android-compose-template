package org.mrlem.android.core.feature.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Navigator {

    data class Operation(
        val destination: Destination,
        val navOptions: NavOptions?,
    )

    private val _operations = MutableSharedFlow<Operation>(extraBufferCapacity = 3)
    val operations: Flow<Operation> = _operations

    fun navigate(destination: Destination, builder: (NavOptionsBuilder.() -> Unit)? = null) {
        val operation = Operation(
            destination = destination,
            navOptions = builder?.let { navOptions(builder) },
        )
        _operations.tryEmit(operation)
    }

}

@Composable
fun NavigationLaunchedEffect(
    navigator: Navigator,
    navController: NavController,
    target: Destination.Target = Destination.Target.DEFAULT,
) {
    LaunchedEffect(Unit) {
        navigator.operations
            .filter { it.destination.target == target }
            .onEach { (destination, navOptions) ->
                navController.navigate(destination.toString(), navOptions)
            }
            .launchIn(this)
    }
}
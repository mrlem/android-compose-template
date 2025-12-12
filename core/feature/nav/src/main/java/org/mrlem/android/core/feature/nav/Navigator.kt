package org.mrlem.android.core.feature.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class Navigator(
    private val scope: CoroutineScope,
) {

    sealed interface Target {

        data object Default : Target
    }

    sealed interface Operation {

        val target: Target

        data class Push(
            val key: NavKey,
            override val target: Target = Target.Default,
        ) : Operation

        data class ReplaceAll(
            val key: NavKey,
            override val target: Target = Target.Default,
        ) : Operation
    }

    private val _operations = MutableSharedFlow<Operation>(extraBufferCapacity = 3)
    val operations: Flow<Operation> = _operations

    fun navigate(operation: Operation) {
        scope.launch {
            _operations.emit(operation)
        }
    }
}

@Composable
fun NavigationLaunchedEffect(
    navigator: Navigator,
    backStack: NavBackStack<NavKey>,
    target: Navigator.Target = Navigator.Target.Default,
) {
    LaunchedEffect(Unit) {
        navigator.operations
            .filter { it.target == target }
            .onEach { operation ->
                when (operation) {
                    is Navigator.Operation.Push -> {
                        backStack.add(operation.key)
                    }

                    is Navigator.Operation.ReplaceAll -> {
                        backStack.clear()
                        backStack.add(operation.key)
                    }
                }
            }
            .launchIn(this)
    }
}
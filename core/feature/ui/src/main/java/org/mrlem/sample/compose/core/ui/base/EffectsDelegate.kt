package org.mrlem.sample.compose.core.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class EffectsDelegate<E : Any>: EffectsProvider<E> {

    override val effects = MutableSharedFlow<E>()

    override fun CoroutineScope.sendEffect(effect: E) {
        launch { effects.emit(effect) }
    }

}
package org.mrlem.android.core.feature.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class EffectsDelegate<E : Any>: EffectsProvider<E> {

    override val effects = MutableSharedFlow<E>()

    override fun CoroutineScope.sendEffect(effect: E) {
        launch { effects.emit(effect) }
    }

}
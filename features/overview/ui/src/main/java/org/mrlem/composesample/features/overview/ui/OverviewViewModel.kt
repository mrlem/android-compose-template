package org.mrlem.composesample.features.overview.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.mrlem.android.core.feature.ui.UnidirectionalViewModel
import org.mrlem.composesample.features.library.domain.usecase.GetRandomBookmark
import javax.inject.Inject

@HiltViewModel
internal class OverviewViewModel @Inject constructor(
    getRandomBookmark: GetRandomBookmark,
    converter: OverviewViewStateConverter,
) : UnidirectionalViewModel<OverviewViewState, Unit, Unit>() {

    override val state = getRandomBookmark()
        .map { bookmark -> converter.toViewState(bookmark) }
        .stateIn(viewModelScope, WhileSubscribed(), OverviewViewState())
}
package org.mrlem.sample.compose.features.library.ui.artist

import dagger.hilt.android.lifecycle.HiltViewModel
import org.mrlem.sample.compose.core.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
): BaseViewModel<ArtistViewState, ArtistViewEffect>(
    initial = ArtistViewState(),
) {

    fun onAction(action: ArtistViewAction) {
        when (action) {
            is ArtistViewAction.Back ->
                sendEffect(ArtistViewEffect.GoBack)
        }
    }
}
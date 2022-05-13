package org.mrlem.sample.compose.feature.feature3.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

internal data class FilmDetailViewState(
    val image: String? = null,
    val title: String = "",
    val originalTitle: String = "",
    val originalTitleRomanised: String = "",
    val summary: String = "",
    val director: String = "",
    val releaseDate: String = "",
    val favoriteState: FavoriteViewState = FavoriteViewState(),
)

data class FavoriteViewState(
    @DrawableRes val drawable: Int = R.drawable.ic_favorite_off,
    @StringRes val text: Int = R.string.filmdetail_favorite_add,
    val color: Color = Color.LightGray,
)
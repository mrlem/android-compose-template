package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FilmDetailState(
    val title: String = "",
    @DrawableRes val favoriteDrawable: Int = R.drawable.ic_favorite_off,
    @StringRes val favoriteText: Int = R.string.filmdetail_favorite_add,
)
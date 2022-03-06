package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color

data class FilmDetailState(
    val image: String? = null,
    val title: String = "",
    val originalTitle: String = "",
    val originalTitleRomanised: String = "",
    val summary: String = "",
    val director: String = "",
    val releaseDate: String = "",
    @DrawableRes val favoriteDrawable: Int = R.drawable.ic_favorite_off,
    @StringRes val favoriteText: Int = R.string.filmdetail_favorite_add,
    val favoriteColor: Color = Color.LightGray,
)
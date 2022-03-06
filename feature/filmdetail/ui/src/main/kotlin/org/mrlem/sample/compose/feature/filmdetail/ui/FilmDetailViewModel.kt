package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.ui.StateDelegate
import org.mrlem.sample.compose.arch.ui.StateProvider
import org.mrlem.sample.compose.design.theme.Palette.RedHeart
import org.mrlem.sample.compose.feature.favorites.domain.repository.FavoriteRepository
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import javax.inject.Inject

@HiltViewModel
class FilmDetailViewModel @Inject constructor(
    private val ghibliRepository: GhibliRepository,
    private val favoriteRepository: FavoriteRepository,
) : ViewModel(),
    StateProvider<FilmDetailState> by StateDelegate(FilmDetailState()) {

    private val filmId = "58611129-2dbc-4a81-a72f-77ddfc1b1b49"

    init {
        viewModelScope.launch {
            try {
                val film = ghibliRepository.getFilm(filmId)
                updateState { copy(
                    image = film.image,
                    title = film.title,
                    originalTitle = film.originalTitle,
                    originalTitleRomanised = film.originalTitleRomanized,
                    summary = film.description,
                    director = film.director,
                    releaseDate = film.releaseDate,
                ) }
            } catch (e: Exception) {
                println("film retrieval failed: ${e.localizedMessage}")
            }
        }

        viewModelScope.launch {
            favoriteRepository.isFavorite(filmId)
                .collect { isFavorite ->
                    val (drawable, text, color) = if (isFavorite) {
                        Triple(R.drawable.ic_favorite_on, R.string.filmdetail_favorite_remove, RedHeart)
                    } else {
                        Triple(R.drawable.ic_favorite_off, R.string.filmdetail_favorite_add, Color.LightGray)
                    }
                    updateState { copy(
                        favoriteDrawable = drawable,
                        favoriteText = text,
                        favoriteColor = color,
                    ) }
                }
        }
    }

    fun toggleFavorite() = viewModelScope.launch {
        favoriteRepository.toggle(filmId)
    }

}
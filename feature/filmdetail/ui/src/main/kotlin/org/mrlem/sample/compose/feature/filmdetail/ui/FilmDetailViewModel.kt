package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
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
    savedStateHandle: SavedStateHandle,
) : ViewModel(),
    StateProvider<FilmDetailState> by StateDelegate(FilmDetailState()) {

    companion object {
        const val STATE_ID = "id"
    }

    private val filmId: String = savedStateHandle.get<String>(STATE_ID)!!

    init {
        loadFilm(filmId)
    }

    private fun loadFilm(filmId: String) {
        viewModelScope.launch {
            try {
                val film = ghibliRepository.getFilm(filmId)
                updateState { copy(
                    image = film.bannerImage,
                    title = film.title,
                    originalTitle = film.originalTitle,
                    originalTitleRomanised = film.originalTitleRomanised,
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
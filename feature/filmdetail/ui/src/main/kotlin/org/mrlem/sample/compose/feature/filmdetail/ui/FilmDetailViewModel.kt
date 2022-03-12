package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
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

    private var getFilmJob: Job? = null
    private var isFavoriteJob: Job? = null

    // FIXME - no support for hilt view model assisted injection yet: see
    //  https://github.com/google/dagger/issues/2287
    var filmId: String? = null
        set(value) {
            if (field == value) return

            // load new film
            cancelFilm()
            field = value
                ?.also { loadFilm(it) }
        }

    private fun cancelFilm() {
        getFilmJob?.cancel()
        getFilmJob = null
        isFavoriteJob?.cancel()
        isFavoriteJob = null
    }

    private fun loadFilm(filmId: String) {
        getFilmJob = viewModelScope.launch {
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

        isFavoriteJob = viewModelScope.launch {
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
        filmId?.let { favoriteRepository.toggle(it) }
    }

}
package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.ui.StateDelegate
import org.mrlem.sample.compose.arch.ui.StateProvider
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
                updateState { copy(title = film.title) }
            } catch (e: Exception) {
                println("film retrieval failed: ${e.localizedMessage}")
            }
        }

        viewModelScope.launch {
            favoriteRepository.isFavorite(filmId)
                .collect { isFavorite ->
                    val (drawable, text) = if (isFavorite) {
                        R.drawable.ic_favorite_on to R.string.filmdetail_favorite_remove
                    } else {
                        R.drawable.ic_favorite_off to R.string.filmdetail_favorite_add
                    }
                    updateState { copy(
                        favoriteDrawable = drawable,
                        favoriteText = text,
                    ) }
                }
        }
    }

    fun toggleFavorite() = viewModelScope.launch {
        favoriteRepository.toggle(filmId)
    }

}
package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.domain.Loadable
import org.mrlem.sample.compose.arch.ui.StateDelegate
import org.mrlem.sample.compose.arch.ui.StateProvider
import org.mrlem.sample.compose.design.theme.Palette.RedHeart
import org.mrlem.sample.compose.feature.ghibli.domain.model.Film
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import javax.inject.Inject

@HiltViewModel
internal class FilmDetailViewModel @Inject constructor(
    private val repository: GhibliRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel(),
    StateProvider<FilmDetailState> by StateDelegate(FilmDetailState()) {

    companion object {
        const val STATE_ID = "id"
    }

    private val filmId: String = savedStateHandle.get<String>(STATE_ID)!!
    private var isFavorite = false

    init {
        loadFilm(filmId)
    }

    private fun loadFilm(filmId: String) {
        viewModelScope.launch {
            try {
                repository.getFilm(filmId)
                    .collect { filmLoadable ->
                        when (filmLoadable) {
                            is Loadable.Loading ->
                                Unit // TODO
                            is Loadable.Success -> {
                                val film = filmLoadable.data
                                updateState { film.toFilmDetailState() }
                                isFavorite = film.isFavorite
                            }
                    }

                }

            } catch (e: Exception) {
                println("film retrieval failed: ${e.localizedMessage}")
            }
        }
    }

    fun toggleFavorite() = viewModelScope.launch {
        if (isFavorite) {
            repository.unfavorite(filmId)
        } else {
            repository.favorite(filmId)
        }
    }

    private fun Film.toFilmDetailState() = FilmDetailState(
        image = bannerImage,
        title = title,
        originalTitle = originalTitle,
        originalTitleRomanised = originalTitleRomanised,
        summary = description,
        director = director,
        releaseDate = releaseDate,
        favoriteState = isFavorite.toFavoriteState(),
    )

    private fun Boolean.toFavoriteState(): FavoriteState {
        val (drawable, text, color) = if (this) {
            Triple(R.drawable.ic_favorite_on, R.string.filmdetail_favorite_remove, RedHeart)
        } else {
            Triple(R.drawable.ic_favorite_off, R.string.filmdetail_favorite_add, Color.LightGray)
        }
        return FavoriteState(
            drawable = drawable,
            text = text,
            color = color,
        )
    }

}
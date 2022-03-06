package org.mrlem.sample.compose

sealed class Screens(val route: String) {

    object Films : Screens("films")
    object FilmDetail : Screens("film/{id}")

}
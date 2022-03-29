package com.setianjay.watchme.ui.search

import androidx.lifecycle.ViewModel
import com.setianjay.watchme.data.repository.MovieRepository

class SearchViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun searchMovie(movieTitle: String) = movieRepository.searchMovie(movieTitle)
}
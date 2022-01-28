package com.setianjay.watchme.ui.home.contents

import androidx.lifecycle.ViewModel
import com.setianjay.watchme.data.repository.MovieRepository

class ContentsViewModel(private val movieRepository: MovieRepository) : ViewModel() {


    fun getDataMovies() = movieRepository.getMoviesPopular()

    fun getTvMovie() = movieRepository.getTvPopular()

}
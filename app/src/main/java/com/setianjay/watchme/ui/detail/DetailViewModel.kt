package com.setianjay.watchme.ui.detail

import androidx.lifecycle.ViewModel
import com.setianjay.watchme.data.repository.MovieRepository


class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovieDetail(movieId: Long) = movieRepository.getMovieDetail(movieId)

    fun getTvDetail(movieId: Long) = movieRepository.getTvDetail(movieId)
}
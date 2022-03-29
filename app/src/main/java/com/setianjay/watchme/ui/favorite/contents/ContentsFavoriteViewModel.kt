package com.setianjay.watchme.ui.favorite.contents

import androidx.lifecycle.ViewModel
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity

class ContentsFavoriteViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getAllMovieBookmarked() = movieRepository.getAllMovieBookmarked()

    fun getAllTvMovieBookmarked() = movieRepository.getAllTvBookmarked()

    fun setFavorite(movieEntity: MovieEntity){
        val newState = !movieEntity.isFavorite
        movieEntity.isFavorite = newState
        movieRepository.setFavorite(movieEntity)
    }
}
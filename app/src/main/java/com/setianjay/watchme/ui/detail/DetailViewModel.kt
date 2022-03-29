package com.setianjay.watchme.ui.detail

import androidx.lifecycle.ViewModel
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity


class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovieDetail(movieId: Long) = movieRepository.getMovieDetail(movieId)

    fun setFavorite(movieEntity: MovieEntity){
        val newState = !movieEntity.isFavorite
        movieEntity.isFavorite = newState
        movieRepository.setFavorite(movieEntity)
    }
}
package com.setianjay.watchme.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.ui.detail.DetailViewModel
import com.setianjay.watchme.ui.home.contents.ContentsViewModel

class MovieViewModelFactory private constructor(private val movieRepository: MovieRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(ContentsViewModel::class.java) -> {
                ContentsViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class ${modelClass.name}")
        }
    }

    companion object {
        private var INSTANCE: MovieViewModelFactory? = null

        fun getInstance(movieRepository: MovieRepository): MovieViewModelFactory {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: MovieViewModelFactory(movieRepository).apply {
                    INSTANCE = this
                }
            }
        }
    }
}
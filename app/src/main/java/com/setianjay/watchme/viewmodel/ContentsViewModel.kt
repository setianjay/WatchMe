package com.setianjay.watchme.viewmodel

import androidx.lifecycle.ViewModel
import com.setianjay.watchme.model.Movies
import com.setianjay.watchme.utils.DataDummyUtil

class ContentsViewModel : ViewModel() {

    fun getDataMovies(isMovies: Boolean): List<Movies> =
        if (isMovies) DataDummyUtil.generateDataMovies() else DataDummyUtil.generateDataTvShows()

    fun getSpecificDataMovies(position: Int, isMovies: Boolean): Movies{
        return if(isMovies) DataDummyUtil.generateDataMovies()[position] else DataDummyUtil.generateDataTvShows()[position]
    }
}
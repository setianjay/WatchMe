package com.setianjay.watchme.data.repository

import androidx.lifecycle.LiveData
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.Resource

interface IMovieDataSource {

    fun getMoviesPopular(): LiveData<Resource<List<MovieEntity>>>

    fun getTvPopular(): LiveData<Resource<List<MovieEntity>>>

    fun getMovieDetail(movieId: Long): LiveData<Resource<MovieEntity>>

    fun getTvDetail(movieId: Long): LiveData<Resource<MovieEntity>>
}
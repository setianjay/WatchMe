package com.setianjay.watchme.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.Resource

interface IMovieDataSource {

    fun getMoviesPopular(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getTvPopular(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovieDetail(movieId: Long): LiveData<MovieEntity>

    fun setFavorite(movieEntity: MovieEntity)
}
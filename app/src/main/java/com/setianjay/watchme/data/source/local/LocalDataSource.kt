package com.setianjay.watchme.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getAllMovie()

    fun getAllTv(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getAllTv()

    fun getAllMovieBookmarked(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getAllMovieBookmarked()

    fun getAllTvBookmarked(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getAllTvBookmarked()

    fun getDetailMovie(movieId: Long): LiveData<MovieEntity> = mMovieDao.getDetailMovie(movieId)

    fun insertMovies(movies: List<MovieEntity>){
        mMovieDao.insertMovies(movies)
    }

    fun updateMovie(movie: MovieEntity){
        mMovieDao.updateMovie(movie)
    }

    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource{
            return INSTANCE ?: LocalDataSource(movieDao)
        }
    }
}
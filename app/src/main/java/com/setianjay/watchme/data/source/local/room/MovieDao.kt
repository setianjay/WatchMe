package com.setianjay.watchme.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.setianjay.watchme.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM tbl_movie WHERE is_movie = 1")
    fun getAllMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_movie WHERE is_movie = 0")
    fun getAllTv(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_movie WHERE is_favorite = 1 AND is_movie = 1")
    fun getAllMovieBookmarked(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_movie WHERE is_favorite = 1 AND is_movie = 0")
    fun getAllTvBookmarked(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tbl_movie WHERE movie_id = :movieId")
    fun getDetailMovie(movieId: Long): LiveData<MovieEntity>

    @Query("SELECT * FROM tbl_movie WHERE title LIKE :movieTitle")
    fun searchMovie(movieTitle: String): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)
}
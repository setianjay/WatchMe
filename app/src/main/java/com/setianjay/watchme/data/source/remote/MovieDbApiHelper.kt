package com.setianjay.watchme.data.source.remote

import com.setianjay.watchme.data.source.remote.response.*
import com.setianjay.watchme.data.source.remote.retrofit.MovieDbEndpoint
import retrofit2.Response

/**
 * helper class for calling endpoint of API
 * */
class MovieDbApiHelper(private val movieDbEndpoint: MovieDbEndpoint) {

    /* interface for handle callback data */
    interface LoadMoviesCallback{
        fun onAllMoviesReceived(movies: Response<MovieResponse>)
    }

    interface LoadTvCallback{
        fun onAllTvReceived(tv: Response<TvResponse>)
    }

    interface LoadGenresCallback{
        fun onAllGenresReceived(genres: Response<GenresResponse>)
    }

    interface LoadMovieDetail{
        fun onMovieDetailReceived(movie: Response<DetailMovieResponse>)
    }

    interface LoadTvDetail{
        fun onTvDetailReceived(tv: Response<DetailTvResponse>)
    }

    /* function helper to call each endpoint of api */
    suspend fun getMoviesPopular(callback: LoadMoviesCallback) {
        callback.onAllMoviesReceived(movieDbEndpoint.getMoviePopular())
    }

    suspend fun getTvPopular(callback: LoadTvCallback) {
        callback.onAllTvReceived(movieDbEndpoint.getTvPopular())
    }

    suspend fun getMovieGenres(callback: LoadGenresCallback){
        callback.onAllGenresReceived(movieDbEndpoint.getMovieGenre())
    }

    suspend fun getTvGenres(callback: LoadGenresCallback){
        callback.onAllGenresReceived(movieDbEndpoint.getTvGenre())
    }

    suspend fun getMovieDetail(movieId: Long, callback: LoadMovieDetail){
        callback.onMovieDetailReceived(movieDbEndpoint.getMovieDetail(movieId))
    }

    suspend fun getTvDetail(movieId: Long, callback: LoadTvDetail){
        callback.onTvDetailReceived(movieDbEndpoint.getTvDetail(movieId))
    }

}
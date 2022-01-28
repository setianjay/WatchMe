package com.setianjay.watchme.data.source.remote

import com.setianjay.watchme.data.source.remote.response.DetailMovieResponse
import com.setianjay.watchme.data.source.remote.response.DetailTvResponse
import com.setianjay.watchme.data.source.remote.response.MovieResponse
import com.setianjay.watchme.data.source.remote.response.TvResponse
import com.setianjay.watchme.data.source.remote.retrofit.MovieDbEndpoint
import com.setianjay.watchme.utils.BackgroundUtil
import com.setianjay.watchme.utils.EspressoIdlingResources
import kotlinx.coroutines.launch

/**
 * helper class for calling endpoint of API
 * */
class MovieDbApiHelper(private val movieDbEndpoint: MovieDbEndpoint) {
    //coroutine for running background task
    private val coroutineScope = BackgroundUtil.coroutineScope

    /* interface for handle callback data */
    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movies: List<MovieResponse.MovieItem>)
    }

    interface LoadTvCallback {
        fun onAllTvReceived(tv: List<TvResponse.TvItem>)
    }

    interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(movie: DetailMovieResponse)
    }

    interface LoadTvDetailCallback {
        fun onTvDetailReceived(tv: DetailTvResponse)
    }

    /* function helper to call each endpoint of api */
    fun getMoviesPopular(callback: LoadMoviesCallback) {
        coroutineScope.launch {
            EspressoIdlingResources.increment()
            try {
                val dataResponse = movieDbEndpoint.getMoviePopular()
                if (dataResponse.isSuccessful) {
                    val listMovies = dataResponse.body()?.moviesItem
                    if (listMovies != null) {
                        callback.onAllMoviesReceived(listMovies)
                        EspressoIdlingResources.decrement()
                    }
                } else {
                    callback.onAllMoviesReceived(emptyList())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                callback.onAllMoviesReceived(emptyList())
                EspressoIdlingResources.decrement()
            }
        }
    }

    fun getTvPopular(callback: LoadTvCallback) {
        coroutineScope.launch {
            EspressoIdlingResources.increment()
            try {
                val dataResponse = movieDbEndpoint.getTvPopular()
                if (dataResponse.isSuccessful) {
                    val listMovies = dataResponse.body()?.tv
                    if (listMovies != null) {
                        callback.onAllTvReceived(listMovies)
                        EspressoIdlingResources.decrement()
                    }
                } else {
                    callback.onAllTvReceived(emptyList())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                callback.onAllTvReceived(emptyList())
                EspressoIdlingResources.decrement()
            }
        }
    }

    fun getMovieDetail(movieId: Long, callback: LoadMovieDetailCallback) {
        coroutineScope.launch {
            EspressoIdlingResources.increment()
            try {
                val dataResponse = movieDbEndpoint.getMovieDetail(movieId)
                if (dataResponse.isSuccessful) {
                    val detailMovie = dataResponse.body()
                    detailMovie?.let { callback.onMovieDetailReceived(it) }
                    EspressoIdlingResources.decrement()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                EspressoIdlingResources.decrement()
            }
        }
    }

    fun getTvDetail(movieId: Long, callback: LoadTvDetailCallback) {
        coroutineScope.launch {
            EspressoIdlingResources.increment()
            try {
                val dataResponse = movieDbEndpoint.getTvDetail(movieId)
                if (dataResponse.isSuccessful) {
                    val detailMovie = dataResponse.body()
                    detailMovie?.let { callback.onTvDetailReceived(it) }
                    EspressoIdlingResources.decrement()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                EspressoIdlingResources.decrement()
            }
        }
    }

}


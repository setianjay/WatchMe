package com.setianjay.watchme.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    /* function helper to call each endpoint of api */
    fun getMoviesPopular(): LiveData<ApiResponse<List<MovieResponse.MovieItem>>> {
        val result = MutableLiveData<ApiResponse<List<MovieResponse.MovieItem>>>()

        coroutineScope.launch {
            EspressoIdlingResources.increment()
            try {
                val dataResponse = movieDbEndpoint.getMoviePopular()
                if (dataResponse.isSuccessful) {
                    val listMovies = dataResponse.body()?.moviesItem
                    if (listMovies != null) {
                        result.postValue(ApiResponse.success(listMovies))
                        EspressoIdlingResources.decrement()
                    }
                } else {
                    result.postValue(ApiResponse.error("No data", emptyList()))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                result.postValue(ApiResponse.error("No data", emptyList()))
                EspressoIdlingResources.decrement()
            }
        }

        return result
    }

    fun getTvPopular(): LiveData<ApiResponse<List<TvResponse.TvItem>>> {
        val result = MutableLiveData<ApiResponse<List<TvResponse.TvItem>>>()

        coroutineScope.launch {
            EspressoIdlingResources.increment()
            try {
                val dataResponse = movieDbEndpoint.getTvPopular()
                if (dataResponse.isSuccessful) {
                    val listMovies = dataResponse.body()?.tv
                    if (listMovies != null) {
                        result.postValue(ApiResponse.success(listMovies))
                        EspressoIdlingResources.decrement()
                    }
                } else {
                    result.postValue(ApiResponse.error("No data", emptyList()))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                result.postValue(ApiResponse.error("No data", emptyList()))
                EspressoIdlingResources.decrement()
            }
        }

        return result
    }

}


package com.setianjay.watchme.utils

import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.remote.MovieDbApiHelper
import com.setianjay.watchme.data.source.remote.retrofit.MovieDbApiBuilder

object Injection {

    /**
     * to provide movie repository
     *
     * @return      MovieRepository class
     * */
    fun provideMovieRepository(): MovieRepository{
        val apiHelper = MovieDbApiHelper(MovieDbApiBuilder.getApiService())

        return MovieRepository(apiHelper)
    }
}
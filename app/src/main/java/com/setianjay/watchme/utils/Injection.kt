package com.setianjay.watchme.utils

import android.content.Context
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.LocalDataSource
import com.setianjay.watchme.data.source.local.room.MovieDatabase
import com.setianjay.watchme.data.source.remote.MovieDbApiHelper
import com.setianjay.watchme.data.source.remote.retrofit.MovieDbApiBuilder

object Injection {

    /**
     * to provide movie repository
     *
     * @return      MovieRepository class
     * */
    fun provideMovieRepository(context: Context): MovieRepository{
        val apiHelper = MovieDbApiHelper(MovieDbApiBuilder.getApiService())

        val movieDatabase = MovieDatabase.getInstance(context)
        val local = LocalDataSource.getInstance(movieDatabase.movieDao())

        return MovieRepository.getInstance(apiHelper, local)
    }
}
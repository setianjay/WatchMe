package com.setianjay.watchme.data.source.remote.retrofit

import com.setianjay.watchme.BuildConfig
import com.setianjay.watchme.data.source.remote.response.MovieResponse
import com.setianjay.watchme.data.source.remote.response.TvResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbEndpoint {

    @GET("movie/popular")
    suspend fun getMoviePopular(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<MovieResponse>

    @GET("tv/popular")
    suspend fun getTvPopular(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<TvResponse>
}
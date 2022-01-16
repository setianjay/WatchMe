package com.setianjay.watchme.data.source.remote.retrofit

import com.setianjay.watchme.BuildConfig
import com.setianjay.watchme.data.source.remote.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbEndpoint {

    @GET("movie/popular")
    suspend fun getMoviePopular(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<MovieResponse>

    @GET("tv/popular")
    suspend fun getTvPopular(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<TvResponse>

    @GET("genre/movie/list")
    suspend fun getMovieGenre(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<GenresResponse>

    @GET("genre/tv/list")
    suspend fun getTvGenre(@Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<GenresResponse>

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: Long, @Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<DetailMovieResponse>

    @GET("tv/{id}")
    suspend fun getTvDetail(@Path("id") id: Long, @Query("api_key") apiKey: String = BuildConfig.API_KEY): Response<DetailTvResponse>
}
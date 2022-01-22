package com.setianjay.watchme.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * class for handle response for detail movie API
 * */
data class DetailMovieResponse(
    @SerializedName("genres") val genres: List<GenresResponse.GenreItem>,
    @SerializedName("id") val movieId: Long,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val poster: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("title") val title: String
)
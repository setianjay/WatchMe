package com.setianjay.watchme.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * class for handle response for movie popular API
 * */
data class MovieResponse(
    @SerializedName("results") val moviesItem: List<MovieItem>
){
    data class MovieItem(
        @SerializedName("id") val movieId: Long,
        @SerializedName("title") val title: String,
        @SerializedName("poster_path") val poster: String,
        @SerializedName("genre_ids") val genreId: List<Int>,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("vote_average") val rating: Float
    )
}

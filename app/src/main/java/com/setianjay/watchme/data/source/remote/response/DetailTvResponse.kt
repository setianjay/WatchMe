package com.setianjay.watchme.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * class for handle response for detail tv API
 * */
data class DetailTvResponse(
    @SerializedName("genres") val genres: List<GenresResponse.GenreItem>,
    @SerializedName("id") val tvId: Long,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val poster: String,
    @SerializedName("vote_average") val rating: Float,
    @SerializedName("first_air_date") val releaseDate: String,
    @SerializedName("name") val title: String
)
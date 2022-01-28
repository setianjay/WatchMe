package com.setianjay.watchme.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * class for handle response for tv popular API
 * */
data class TvResponse(
    @SerializedName("results") val tv: List<TvItem>
){
    data class TvItem(
        @SerializedName("id") val tvId: Long,
        @SerializedName("name") val title: String,
        @SerializedName("poster_path") val poster: String,
        @SerializedName("genre_ids") val genreId: List<Int>,
        @SerializedName("overview") val overview: String,
        @SerializedName("first_air_date") val releaseDate: String,
        @SerializedName("vote_average") val rating: Float
    )
}

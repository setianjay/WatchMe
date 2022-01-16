package com.setianjay.watchme.data.source.remote.response

import com.google.gson.annotations.SerializedName

/**
 * class for handle response for genres API
 * */
data class GenresResponse(
    val genres: List<GenreItem>
){
    data class GenreItem(
        @SerializedName("id") val genreId: Int,
        @SerializedName("name") val genre: String
    )
}

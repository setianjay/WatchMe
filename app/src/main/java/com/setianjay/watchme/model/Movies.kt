package com.setianjay.watchme.model


data class Movies(
    val title: String,
    val poster: Int,
    val director: String,
    val duration: String,
    val overview: String,
    val genre: List<String>,
    val rating: Float
)

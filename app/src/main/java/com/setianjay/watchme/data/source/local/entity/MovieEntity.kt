package com.setianjay.watchme.data.source.local.entity

data class MovieEntity(
    val movieId: Long,
    val title: String,
    val poster: String,
    val overview: String,
    val rating: Float,
    val release: String,
    val genre: String
)
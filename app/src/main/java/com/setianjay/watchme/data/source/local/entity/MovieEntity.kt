package com.setianjay.watchme.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tbl_movie")
@Parcelize
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movie_id")
    val movieId: Long,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "poster")
    val poster: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "rating")
    val rating: Float,

    @ColumnInfo(name = "release")
    val release: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "is_movie")
    val isMovies: Boolean,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
): Parcelable
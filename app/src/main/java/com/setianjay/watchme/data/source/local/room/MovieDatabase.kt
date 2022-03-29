package com.setianjay.watchme.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.setianjay.watchme.data.source.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object{
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    MovieDatabase::class.java,
                    "db_movie"
                    ).build().apply {
                        INSTANCE = this
                }
            }
        }
    }
}
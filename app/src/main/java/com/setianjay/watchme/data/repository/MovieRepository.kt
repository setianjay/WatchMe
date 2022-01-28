package com.setianjay.watchme.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.MovieDbApiHelper
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.data.source.remote.constant.RemoteConst
import com.setianjay.watchme.data.source.remote.response.DetailMovieResponse
import com.setianjay.watchme.data.source.remote.response.DetailTvResponse
import com.setianjay.watchme.data.source.remote.response.MovieResponse
import com.setianjay.watchme.data.source.remote.response.TvResponse
import com.setianjay.watchme.utils.DataDummyUtil

class MovieRepository private constructor(private val apiHelper: MovieDbApiHelper) :
    IMovieDataSource {

    /**
     * to get list of movie popular
     *
     * @return  LiveData<Resource<List<MovieEntity>>>
     * */
    override fun getMoviesPopular(): LiveData<Resource<List<MovieEntity>>> {
        val moviesResult = MutableLiveData<Resource<List<MovieEntity>>>()
        moviesResult.postValue(Resource.loading())
        apiHelper.getMoviesPopular(object : MovieDbApiHelper.LoadMoviesCallback {
            override fun onAllMoviesReceived(movies: List<MovieResponse.MovieItem>) {
                val listMovie = ArrayList<MovieEntity>()
                if (movies.isNotEmpty()) {
                    for (i in movies.indices) {
                        //to get specific genre based on list genreId


                        //move movie response to movie entity
                        val movieEntity = MovieEntity(
                            movies[i].movieId,
                            movies[i].title,
                            movies[i].poster,
                            movies[i].overview,
                            movies[i].rating,
                            movies[i].releaseDate,
                            DataDummyUtil.getMovieGenre(movies[i].genreId)
                        )

                        listMovie.add(movieEntity)
                    }
                    moviesResult.postValue(Resource.success(listMovie))
                } else {
                    moviesResult.postValue(Resource.error(RemoteConst.ERROR_API))
                }
            }
        })

        return moviesResult
    }


    /**
     * to get list of tv popular
     *
     * @return  LiveData<Resource<List<MovieEntity>>>
     * */
    override fun getTvPopular(): LiveData<Resource<List<MovieEntity>>> {
        val tvResult = MutableLiveData<Resource<List<MovieEntity>>>()

        tvResult.postValue(Resource.loading())
        apiHelper.getTvPopular(object : MovieDbApiHelper.LoadTvCallback {
            override fun onAllTvReceived(tv: List<TvResponse.TvItem>) {
                val listTv = ArrayList<MovieEntity>()
                if (tv.isNotEmpty()) {
                    for (i in tv.indices) {
                        //to get specific genre based on list genreId

                        //move tv response to movie entity
                        val movieEntity = MovieEntity(
                            tv[i].tvId,
                            tv[i].title,
                            tv[i].poster,
                            tv[i].overview,
                            tv[i].rating,
                            tv[i].releaseDate,
                            DataDummyUtil.getTvGenre(tv[i].genreId)
                        )
                        listTv.add(movieEntity)
                    }
                    tvResult.postValue(Resource.success(listTv))
                } else {
                    tvResult.postValue(Resource.error(RemoteConst.ERROR_API))
                }
            }
        })
        return tvResult
    }

    /**
     * to get movie detail based on movie id
     *
     * @param movieId   id of movie
     * @return          LiveData<Resource<MovieEntity>>
     * */
    override fun getMovieDetail(movieId: Long): LiveData<Resource<MovieEntity>> {
        val movieDetailResult = MutableLiveData<Resource<MovieEntity>>()

        movieDetailResult.postValue(Resource.loading())
        apiHelper.getMovieDetail(movieId, object : MovieDbApiHelper.LoadMovieDetailCallback {
            override fun onMovieDetailReceived(movie: DetailMovieResponse) {
                val genre = StringBuilder()

                for (i in movie.genres) {
                    genre.append("${i.genre}, ")
                }

                val movieEntity = MovieEntity(
                    movie.movieId,
                    movie.title,
                    movie.poster,
                    movie.overview,
                    movie.rating,
                    movie.releaseDate,
                    genre.toString()
                )

                movieDetailResult.postValue(Resource.success(movieEntity))

            }

        })
        return movieDetailResult
    }

    /**
     * to get tv detail based on movie id
     *
     * @param movieId   id of movie
     * @return          LiveData<Resource<MovieEntity>>
     * */
    override fun getTvDetail(movieId: Long): LiveData<Resource<MovieEntity>> {
        val tvDetailResult = MutableLiveData<Resource<MovieEntity>>()

        tvDetailResult.postValue(Resource.loading())
        apiHelper.getTvDetail(movieId, object : MovieDbApiHelper.LoadTvDetailCallback {
            override fun onTvDetailReceived(tv: DetailTvResponse) {
                val genre = StringBuilder()

                for (i in tv.genres) {
                    genre.append("${i.genre}, ")
                }

                val movieEntity = MovieEntity(
                    tv.tvId,
                    tv.title,
                    tv.poster,
                    tv.overview,
                    tv.rating,
                    tv.releaseDate,
                    genre.toString()
                )

                tvDetailResult.postValue(Resource.success(movieEntity))
            }
        })
        return tvDetailResult
    }

    companion object {
        private var INSTANCE: MovieRepository? = null

        fun getInstance(movieRepository: MovieDbApiHelper): MovieRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = MovieRepository(movieRepository)
                INSTANCE = instance
                instance
            }
        }
    }
}
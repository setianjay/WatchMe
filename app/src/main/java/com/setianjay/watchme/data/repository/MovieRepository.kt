package com.setianjay.watchme.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.MovieDbApiHelper
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.data.source.remote.constant.RemoteConst
import com.setianjay.watchme.data.source.remote.response.*
import com.setianjay.watchme.utils.FormatUtil
import kotlinx.coroutines.*
import retrofit2.Response
import java.lang.Exception
import java.lang.StringBuilder

class MovieRepository(private val apiHelper: MovieDbApiHelper) : IMovieDataSource {

    //coroutineScope for handle background process
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    /**
     * to get list of movie popular
     *
     * @return  LiveData<Resource<List<MovieEntity>>>
     * */
    override fun getMoviesPopular(): LiveData<Resource<List<MovieEntity>>> {
        val moviesResult = MutableLiveData<Resource<List<MovieEntity>>>()

        moviesResult.postValue(Resource.loading())
        coroutineScope.launch {
            try {
                apiHelper.getMoviesPopular(object : MovieDbApiHelper.LoadMoviesCallback {
                    override fun onAllMoviesReceived(movies: Response<MovieResponse>) {
                        coroutineScope.launch {
                            val listMovie = ArrayList<MovieEntity>()
                            if (movies.isSuccessful) {
                                val dataResponse = movies.body()?.moviesItem
                                if (dataResponse != null) {
                                    for (i in dataResponse.indices) {
                                        //to get specific genre based on list genreId
                                        val genre = withContext(Dispatchers.IO) {
                                            getMoviesGenre(dataResponse[i].genreId)
                                        }

                                        //move movie response to movie entity
                                        val movieEntity = MovieEntity(
                                            dataResponse[i].movieId,
                                            dataResponse[i].title,
                                            dataResponse[i].poster,
                                            dataResponse[i].overview,
                                            dataResponse[i].rating,
                                            FormatUtil.dateFormat(dataResponse[i].releaseDate),
                                            FormatUtil.genreFormat(genre)
                                        )

                                        listMovie.add(movieEntity)
                                    }
                                    moviesResult.postValue(Resource.success(listMovie))
                                }
                            } else {
                                moviesResult.postValue(Resource.error(RemoteConst.ERROR_API))
                            }
                        }
                    }
                })
            } catch (e: Exception) {
                e.printStackTrace()
                moviesResult.postValue(Resource.error(RemoteConst.ERROR_API))
            }
        }

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
        coroutineScope.launch {
            try {
                apiHelper.getTvPopular(object : MovieDbApiHelper.LoadTvCallback {
                    override fun onAllTvReceived(tv: Response<TvResponse>) {
                        coroutineScope.launch {
                            val listTv = ArrayList<MovieEntity>()
                            if (tv.isSuccessful) {
                                val dataResponse = tv.body()?.tv
                                if (dataResponse != null) {
                                    for (i in dataResponse.indices) {
                                        //to get specific genre based on list genreId
                                        val genre = withContext(Dispatchers.IO){
                                            getTvGenre(dataResponse[i].genreId)
                                        }

                                        //move tv response to movie entity
                                        val movieEntity = MovieEntity(
                                            dataResponse[i].tvId,
                                            dataResponse[i].title,
                                            dataResponse[i].poster,
                                            dataResponse[i].overview,
                                            dataResponse[i].rating,
                                            FormatUtil.dateFormat(dataResponse[i].releaseDate),
                                            FormatUtil.genreFormat(genre)
                                        )
                                        listTv.add(movieEntity)
                                    }
                                    tvResult.postValue(Resource.success(listTv))
                                }
                            } else {
                                tvResult.postValue(Resource.error(RemoteConst.ERROR_API))
                            }
                        }
                    }
                })
            } catch (e: Exception) {
                e.printStackTrace()
                tvResult.postValue(Resource.error(RemoteConst.ERROR_API))
            }
        }
        return tvResult
    }

    /**
     * to get specific movie genre based on list of genre id
     *
     * @param genreId   list id of genre
     * @return          String of genre
     * */
    override suspend fun getMoviesGenre(genreId: List<Int>): String {
        val genresBuilder = StringBuilder()
        try {
            apiHelper.getMovieGenres(object : MovieDbApiHelper.LoadGenresCallback {
                override fun onAllGenresReceived(genres: Response<GenresResponse>) {
                    if (genres.isSuccessful) {
                        val dataResponse = genres.body()?.genres
                        if (dataResponse != null) {
                            for (i in genreId) {
                                for (j in dataResponse) {
                                    if (i != j.genreId) {
                                        continue
                                    }
                                    genresBuilder.append("${j.genre}, ")
                                }
                            }
                        }
                    }
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return genresBuilder.toString()
    }

    /**
     * to get specific tv genre based on list of genre id
     *
     * @param genreId   list of id genre
     * @return          String of genre
     * */
    override suspend fun getTvGenre(genreId: List<Int>): String {
        val genresBuilder = StringBuilder()
        try {
            apiHelper.getTvGenres(object : MovieDbApiHelper.LoadGenresCallback {
                override fun onAllGenresReceived(genres: Response<GenresResponse>) {
                    if (genres.isSuccessful) {
                        val dataResponse = genres.body()?.genres
                        if (dataResponse != null) {
                            for (i in genreId) {
                                for (j in dataResponse) {
                                    if (i != j.genreId) {
                                        continue
                                    }
                                    genresBuilder.append("${j.genre}, ")
                                }
                            }
                        }
                    }
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return genresBuilder.toString()
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
        coroutineScope.launch {
            try {
                delay(1000L)
                apiHelper.getMovieDetail(movieId, object : MovieDbApiHelper.LoadMovieDetail{
                    override fun onMovieDetailReceived(movie: Response<DetailMovieResponse>) {
                        if (movie.isSuccessful){
                            val dataResponse = movie.body()
                            if (dataResponse != null){
                                val genre = StringBuilder()

                                for (i in dataResponse.genres){
                                    genre.append("${i.genre}, ")
                                }

                                val movieEntity = MovieEntity(
                                    dataResponse.movieId,
                                    dataResponse.title,
                                    dataResponse.poster,
                                    dataResponse.overview,
                                    dataResponse.rating,
                                    FormatUtil.dateFormat(dataResponse.releaseDate),
                                    FormatUtil.genreFormat(genre.toString())
                                )

                                movieDetailResult.postValue(Resource.success(movieEntity))
                            }
                        }else{
                            movieDetailResult.postValue(Resource.error(RemoteConst.ERROR_API))
                        }
                    }

                })
            }catch (e: Exception){
                e.printStackTrace()
                movieDetailResult.postValue(Resource.error(RemoteConst.ERROR_API))
            }
        }
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
        coroutineScope.launch {
            try {
                delay(1000L)
                apiHelper.getTvDetail(movieId, object : MovieDbApiHelper.LoadTvDetail{
                    override fun onTvDetailReceived(tv: Response<DetailTvResponse>) {
                        if (tv.isSuccessful){
                            val dataResponse = tv.body()
                            if (dataResponse != null){
                                val genre = StringBuilder()

                                for (i in dataResponse.genres){
                                    genre.append("${i.genre}, ")
                                }

                                val movieEntity = MovieEntity(
                                    dataResponse.tvId,
                                    dataResponse.title,
                                    dataResponse.poster,
                                    dataResponse.overview,
                                    dataResponse.rating,
                                    FormatUtil.dateFormat(dataResponse.releaseDate),
                                    FormatUtil.genreFormat(genre.toString())
                                )

                                tvDetailResult.postValue(Resource.success(movieEntity))
                            }
                        }else{
                            tvDetailResult.postValue(Resource.error(RemoteConst.ERROR_API))
                        }
                    }
                })
            }catch (e: Exception){
                e.printStackTrace()
                tvDetailResult.postValue(Resource.error(RemoteConst.ERROR_API))
            }
        }
        return tvDetailResult
    }
}
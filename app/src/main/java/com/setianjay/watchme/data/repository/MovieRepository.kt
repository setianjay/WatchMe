package com.setianjay.watchme.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.setianjay.watchme.data.source.NetworkBoundResource
import com.setianjay.watchme.data.source.local.LocalDataSource
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.ApiResponse
import com.setianjay.watchme.data.source.remote.MovieDbApiHelper
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.data.source.remote.response.MovieResponse
import com.setianjay.watchme.data.source.remote.response.TvResponse
import com.setianjay.watchme.utils.BackgroundUtil
import com.setianjay.watchme.utils.DataDummyUtil
import kotlinx.coroutines.launch

class MovieRepository private constructor(
    private val remoteDataSource: MovieDbApiHelper,
    private val localDataSource: LocalDataSource
) :
    IMovieDataSource {

    /**
     * to get list of movie popular
     *
     * @return  LiveData<Resource<List<MovieEntity>>>
     * */
    override fun getMoviesPopular(): LiveData<Resource<PagedList<MovieEntity>>> {

        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse.MovieItem>>() {
            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(20)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse.MovieItem>>> {
                return remoteDataSource.getMoviesPopular()
            }

            override fun saveCallResult(data: List<MovieResponse.MovieItem>) {
                val listMovie = ArrayList<MovieEntity>()
                for (i in data.indices) {
                    //move movie response to movie entity
                    val movieEntity = MovieEntity(
                        data[i].movieId,
                        data[i].title,
                        data[i].poster,
                        data[i].overview,
                        data[i].rating,
                        data[i].releaseDate,
                        DataDummyUtil.getMovieGenre(data[i].genreId),
                        isMovies = true
                    )
                    listMovie.add(movieEntity)
                }
                localDataSource.insertMovies(listMovie)
            }
        }.asLiveData()
    }


    /**
     * to get list of tv popular
     *
     * @return  LiveData<Resource<List<MovieEntity>>>
     * */
    override fun getTvPopular(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<TvResponse.TvItem>>() {
            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(20)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvResponse.TvItem>>> {
                return remoteDataSource.getTvPopular()
            }

            override fun saveCallResult(data: List<TvResponse.TvItem>) {
                val listTv = ArrayList<MovieEntity>()
                for (i in data.indices) {
                    //move tv response to movie entity
                    val movieEntity = MovieEntity(
                        data[i].tvId,
                        data[i].title,
                        data[i].poster,
                        data[i].overview,
                        data[i].rating,
                        data[i].releaseDate,
                        DataDummyUtil.getTvGenre(data[i].genreId),
                        isMovies = false
                    )
                    listTv.add(movieEntity)
                }
                localDataSource.insertMovies(listTv)
            }

        }.asLiveData()
    }

    /**
     * to get movie detail based on movie id
     *
     * @param movieId   id of movie
     * @return          LiveData<Resource<MovieEntity>>
     * */
    override fun getMovieDetail(movieId: Long): LiveData<MovieEntity> {
        return localDataSource.getDetailMovie(movieId)
    }

    /**
     * set movie to favorite
     *
     * @param movieEntity   entity of movie
     * */
    override fun setFavorite(movieEntity: MovieEntity) {
        BackgroundUtil.coroutineScope.launch { localDataSource.updateMovie(movieEntity) }
    }

    /**
     * to get all movie bookmarked
     *
     * @return          LiveData<PagedList<MovieEntity>>
     * */
    override fun getAllMovieBookmarked(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(4)
            .setInitialLoadSizeHint(20)
            .build()

        return LivePagedListBuilder(localDataSource.getAllMovieBookmarked(), config).build()
    }

    /**
     * to get all tv bookmarked
     *
     * @return          LiveData<PagedList<MovieEntity>>
     * */
    override fun getAllTvBookmarked(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(4)
            .setInitialLoadSizeHint(20)
            .build()

        return LivePagedListBuilder(localDataSource.getAllTvBookmarked(), config).build()
    }


    companion object {
        private var INSTANCE: MovieRepository? = null

        fun getInstance(movieRepository: MovieDbApiHelper, localDataSource: LocalDataSource): MovieRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = MovieRepository(movieRepository, localDataSource)
                INSTANCE = instance
                instance
            }
        }
    }
}
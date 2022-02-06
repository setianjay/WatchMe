package com.setianjay.watchme.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.source.local.LocalDataSource
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.MovieDbApiHelper
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.util.LiveDataUtil
import com.setianjay.watchme.util.PagedListUtil
import com.setianjay.watchme.util.TestUtil
import com.setianjay.watchme.utils.DataDummyUtil
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(MovieDbApiHelper::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote, local)

    //dummy data
    private val movieResponse = DataDummyUtil.generateRemoteDataMovies()
    private val tvResponse = DataDummyUtil.generateRemoteDataTv()

    private val movieId = movieResponse[0].movieId

    private val movieTitle = movieResponse[0].title

    private val movieDetail = DataDummyUtil.getDetailMovie()

    @Test
    fun getMoviePopular() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSource)
        local.getAllMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(movieResponse)).data
        verify(local).getAllMovies()
        assertNotNull(movieEntity)
        movieEntity?.let { TestUtil.checkMoviesDataSize(movieResponse, it) }
    }

    @Test
    fun getTvPopular() {
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllTv()).thenReturn(dataSource)
        local.getAllTv()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(tvResponse)).data
        verify(local).getAllTv()
        assertNotNull(movieEntity)
        movieEntity?.let { TestUtil.checkMoviesDataSize(tvResponse, it) }
    }


    @Test
    fun getMovieDetail() {
        val result = MutableLiveData<MovieEntity>()
        result.value = movieDetail
        `when`(local.getDetailMovie(movieId)).thenReturn(result)

        val detailMovie = LiveDataUtil.getValue(movieRepository.getMovieDetail(movieId))
        verify(local).getDetailMovie(movieId)

        assertNotNull(detailMovie)
        TestUtil.checkSpecificMovie(movieDetail, detailMovie)
    }

    @Test
    fun getAllMovieBookmarked(){
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovieBookmarked()).thenReturn(dataSource)
        local.getAllMovieBookmarked()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(movieResponse)).data
        verify(local).getAllMovieBookmarked()
        assertNotNull(movieEntity)
        movieEntity?.let { TestUtil.checkMoviesDataSize(movieResponse, it) }
    }

    @Test
    fun getAllTvBookmarked(){
        val dataSource = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovieBookmarked()).thenReturn(dataSource)
        local.getAllMovieBookmarked()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(tvResponse)).data
        verify(local).getAllMovieBookmarked()
        assertNotNull(movieEntity)
        movieEntity?.let{ TestUtil.checkMoviesDataSize(tvResponse, it) }
    }

    @Test
    fun searchMovie(){
        val dummySearch: List<MovieEntity> = listOf(movieDetail)

        val result = MutableLiveData<List<MovieEntity>>()
        result.value = dummySearch

        `when`(local.searchMovie(movieTitle)).thenReturn(result)
        local.searchMovie(movieTitle)

        val searchResult = LiveDataUtil.getValue(result)[0]
        verify(local).searchMovie(movieTitle)

        assertNotNull(searchResult)
        TestUtil.checkSpecificMovie(movieDetail, searchResult)
    }
}
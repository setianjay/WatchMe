package com.setianjay.watchme.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.source.remote.MovieDbApiHelper
import com.setianjay.watchme.util.LiveDataUtil
import com.setianjay.watchme.utils.DataDummyUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val apiHelper = mock(MovieDbApiHelper::class.java)
    private val movieRepository = FakeMovieRepository(apiHelper)

    //dummy data
    private val movieResponse = DataDummyUtil.generateRemoteDataMovies()
    private val tvResponse = DataDummyUtil.generateRemoteDataTv()

    private val movieId = movieResponse[0].movieId
    private val tvId = tvResponse[0].tvId

    private val movieDetail = DataDummyUtil.generateRemoteDetailMovie()
    private val tvDetail = DataDummyUtil.generateRemoteDetailTv()



    @Test
    fun getMoviePopular() {
        doAnswer { invocation ->
            (invocation.arguments[0] as MovieDbApiHelper.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(apiHelper).getMoviesPopular(any())

        val movies = LiveDataUtil.getValue(movieRepository.getMoviesPopular()).data
        verify(apiHelper).getMoviesPopular(any())
        assertNotNull(movies)
        assertEquals(movieResponse.size.toLong(), movies?.size?.toLong())
    }

    /*
    * - movies data masih null (ubah return callback di movieDbHelper + return data dummy)
    * */
    @Test
    fun getTvPopular() {
        doAnswer { invocation ->
            (invocation.arguments[0] as MovieDbApiHelper.LoadTvCallback)
                .onAllTvReceived(tvResponse)
            null
        }.`when`(apiHelper).getTvPopular(any())

        val movies = LiveDataUtil.getValue(movieRepository.getTvPopular())
        verify(apiHelper).getTvPopular(any())
        println(movies.statusType)
    }


    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as MovieDbApiHelper.LoadMovieDetailCallback)
                .onMovieDetailReceived(movieDetail)
            null
        }.`when`(apiHelper).getMovieDetail(eq(movieId), any())

        val detailMovie = LiveDataUtil.getValue(movieRepository.getMovieDetail(movieId)).data
        verify(apiHelper).getMovieDetail(eq(movieId), any())
        assertNotNull(detailMovie)
        assertEquals(movieDetail.movieId, detailMovie?.movieId)
        assertEquals(movieDetail.title, detailMovie?.title)
        assertEquals(movieDetail.poster, detailMovie?.poster)
        assertEquals(movieDetail.overview, detailMovie?.overview)
        assertEquals(movieDetail.rating, detailMovie?.rating)
        assertEquals(movieDetail.releaseDate, detailMovie?.release)
    }

    @Test
    fun getDetailTv() {
        doAnswer { invocation ->
            (invocation.arguments[1] as MovieDbApiHelper.LoadTvDetailCallback)
                .onTvDetailReceived(tvDetail)
            null
        }.`when`(apiHelper).getTvDetail(eq(tvId), any())

        val detailTv = LiveDataUtil.getValue(movieRepository.getTvDetail(tvId)).data
        verify(apiHelper).getTvDetail(eq(tvId), any())
        assertNotNull(detailTv)
        assertEquals(tvDetail.tvId, detailTv?.movieId)
        assertEquals(tvDetail.title, detailTv?.title)
        assertEquals(tvDetail.poster, detailTv?.poster)
        assertEquals(tvDetail.overview, detailTv?.overview)
        assertEquals(tvDetail.rating, detailTv?.rating)
        assertEquals(tvDetail.releaseDate, detailTv?.release)
    }

}
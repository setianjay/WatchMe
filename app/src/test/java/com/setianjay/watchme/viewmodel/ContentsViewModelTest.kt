package com.setianjay.watchme.viewmodel

import com.setianjay.watchme.utils.DataDummyUtil
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class ContentsViewModelTest {

    private lateinit var viewModel: ContentsViewModel

    @Before
    fun setup(){
        viewModel = ContentsViewModel()
    }

    /**
     * testing to get data movies
     *
     * note: for obtain data movies, the arguments isMovies must true
     * */
    @Test
    fun testGetDataMovies() {
        val movies = viewModel.getDataMovies(true)
        assertNotNull(movies)
        assertEquals(DataDummyUtil.generateDataMovies().size, movies.size)
    }


    /**
     * testing to get data tv shows
     *
     * note: for obtain data tv shows, the arguments isMovies must false
     * */
    @Test
    fun testGetDataTvShows() {
        val tvShows = viewModel.getDataMovies(false)
        assertNotNull(tvShows)
        assertEquals(DataDummyUtil.generateDataTvShows().size, tvShows.size)
    }


    /**
     * testing to get specific data movies
     *
     * note: for obtain specific data of movies, the arguments isMovies must true
     * */
    //success
    @Test
    fun testGetSpecificDataMovies() {
        val getSpecificDataMovies = viewModel.getSpecificDataMovies(0, true)
        assertNotNull(getSpecificDataMovies)
        assertEquals(DataDummyUtil.generateDataMovies()[0].title, getSpecificDataMovies.title)
    }

    //fail, because the title not equals
    @Test
    fun tesGetSpecificDataMoviesFail(){
        val movies = viewModel.getSpecificDataMovies(0, false)
        assertNotNull(movies)
        assertEquals(DataDummyUtil.generateDataMovies()[0].title, movies.title)
    }

    /**
     * testing to get specific tv shows
     *
     * note: for obtain specific data of tv shows, the arguments isMovies must false
     * */
    //success
    @Test
    fun testGetSpecificTvShows() {
        val getSpecificTvShows = viewModel.getSpecificDataMovies(0, false)
        assertNotNull(getSpecificTvShows)
        assertEquals(DataDummyUtil.generateDataTvShows()[0].title, getSpecificTvShows.title)
    }

    //fail, because the title not equals
    @Test
    fun tesGetSpecificTvShowsFail(){
        val movies = viewModel.getSpecificDataMovies(0, true)
        assertNotNull(movies)
        assertEquals(DataDummyUtil.generateDataTvShows()[0].title, movies.title)
    }


}
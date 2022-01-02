package com.setianjay.watchme.viewmodel

import com.setianjay.watchme.utils.DataDummyUtil
import junit.framework.Assert.*
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ContentsViewModelTest {

    private lateinit var viewModel: ContentsViewModel

    private val dummyMovies get() = DataDummyUtil.generateDataMovies()
    private val dummyTvShows get() = DataDummyUtil.generateDataTvShows()

    @Before
    fun setup() {
        viewModel = ContentsViewModel()
    }

    /**
     * testing to get movies data size, equal with movies resources data size
     *
     * note: for obtain movies data, the arguments isMovies must true
     * */
    @Test
    fun testGetDataMoviesSize() {
        checkMoviesDataSize(isMovies = true)
    }


    /**
     * testing to get tv shows data size, equal with tv shows resources data size
     *
     * note: for obtain tv shows data, the arguments isMovies must false
     * */
    @Test
    fun testGetDataTvShowsSize() {
        checkMoviesDataSize(isMovies = false)
    }


    /**
     * testing to get specific movies, equal with movies resources data based on position
     *
     * note: for obtain specific data of movies, the arguments isMovies must true
     * */
    @Test
    fun testGetSpecificMoviesData() {
        checkSpecificMovie(isMovies = true, positionAt = 0)
    }

    /**
     * testing to get specific tv shows, equal with tv shows resources data based on position
     *
     * note: for obtain specific data of tv shows, the arguments isMovies must false
     * */
    @Test
    fun testGetSpecificTvShowsData() {
        checkSpecificMovie(isMovies = false, positionAt = 1)
    }

    /**
     * testing to get specific movies, with wrong passing argument based on position
     *
     * note: for obtain specific data of movies, the arguments isMovies must true.
     *       in this function we pass the wrong arguments isMovies, namely false.
     * */
    @Test
    fun testWrongGetSpecificMoviesData(){
        checkSpecificWrongMovie(isMovies = false, positionAt = 0)
    }

    /**
     * testing to get specific tv shows, with wrong passing argument based on position
     *
     * note: for obtain specific data of tv shows, the arguments isMovies must false.
     *       in this function we pass the wrong arguments isMovies, namely true.
     * */
    @Test
    fun testWrongGetSpecificTvShowsData(){
        checkSpecificWrongMovie(isMovies = true, positionAt = 1)
    }

    /**
     * check size of movies data
     *
     * @param isMovies      <code>true</code> obtain list of movie data, otherwise list of tv show data (@field movie)
     *
     * @output              success, if size of list data is same with data resources size
     * */
    private fun checkMoviesDataSize(isMovies: Boolean){
        val movie = viewModel.getDataMovies(isMovies)
        val moviesResourcesData = if (isMovies) dummyMovies else dummyTvShows
        assertNotNull(movie)
        assertEquals(moviesResourcesData.size, movie.size)
    }

    /**
     * check specific movie, whether is same
     *
     * @param isMovies      <code>true</code> obtain movie data, otherwise tv show data (@field movie)
     * @param positionAt    the position of the data you want to check
     *
     * @output              success, if data is same with data resources
     * */
    private fun checkSpecificMovie(isMovies: Boolean, positionAt: Int) {
        val movie = viewModel.getSpecificDataMovies(positionAt, isMovies)
        //get data resource based on argument
        val moviesResourceData =
            if (isMovies) dummyMovies else dummyTvShows
        assertNotNull(movie)
        assertEquals(moviesResourceData[positionAt].title, movie.title)
        assertEquals(moviesResourceData[positionAt].poster, movie.poster)
        assertEquals(moviesResourceData[positionAt].duration, movie.duration)
        assertEquals(moviesResourceData[positionAt].director, movie.director)
        assertEquals(moviesResourceData[positionAt].rating, movie.rating)
        assertEquals(moviesResourceData[positionAt].genre.size, movie.genre.size)
        assertEquals(moviesResourceData[positionAt].overview, movie.overview)
    }

    /**
     * check specific movie, whether is wrong
     *
     * @param isMovies      <code>true</code> obtain movie data, otherwise tv show data (@field movie)
     * @param positionAt    the position of the data you want to check
     *
     * @output              success, if data is not same with data resources
     * */
    private fun checkSpecificWrongMovie(isMovies: Boolean, positionAt: Int){
        val movie = viewModel.getSpecificDataMovies(positionAt, isMovies)
        //get data resource based on argument
        val moviesResourceData =
            if (isMovies) dummyTvShows else dummyMovies
        assertNotNull(movie)
        assertNotSame(moviesResourceData[positionAt].title, movie.title)
        assertNotSame(moviesResourceData[positionAt].poster, movie.poster)
        assertNotSame(moviesResourceData[positionAt].duration, movie.duration)
        assertNotSame(moviesResourceData[positionAt].director, movie.director)
        assertNotSame(moviesResourceData[positionAt].rating, movie.rating)
        assertNotSame(moviesResourceData[positionAt].genre.size, movie.genre.size)
        assertNotSame(moviesResourceData[positionAt].overview, movie.overview)
    }
}
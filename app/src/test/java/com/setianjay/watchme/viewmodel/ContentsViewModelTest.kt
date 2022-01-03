package com.setianjay.watchme.viewmodel

import com.setianjay.watchme.model.Movies
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
        val movies = viewModel.getDataMovies(true)
        checkMoviesDataSize(expected = dummyMovies, actual = movies)
    }


    /**
     * testing to get tv shows data size, equal with tv shows resources data size
     *
     * note: for obtain tv shows data, the arguments isMovies must false
     * */
    @Test
    fun testGetDataTvShowsSize() {
        val tvShows = viewModel.getDataMovies(false)
        checkMoviesDataSize(expected = dummyTvShows, actual = tvShows)
    }


    /**
     * testing to get specific movies, equal with movies resources data based on position
     *
     * note: for obtain specific data of movies, the arguments isMovies must true
     * */
    @Test
    fun testGetSpecificMoviesData() {
        val position = 0
        val specificMovies = viewModel.getSpecificDataMovies(position, true)
        checkSpecificMovie(expected = dummyMovies, actual = specificMovies, positionAt = position)
    }

    /**
     * testing to get specific tv shows, equal with tv shows resources data based on position
     *
     * note: for obtain specific data of tv shows, the arguments isMovies must false
     * */
    @Test
    fun testGetSpecificTvShowsData() {
        val position = 1
        val specificTvShows = viewModel.getSpecificDataMovies(position, false)
        checkSpecificMovie(expected = dummyTvShows, actual = specificTvShows, positionAt = position)
    }

    /**
     * testing to get specific movies, with wrong passing argument based on position
     *
     * note: for obtain specific data of movies, the arguments isMovies must true.
     *       in this function we pass the wrong arguments isMovies, namely false.
     * */
    @Test
    fun testWrongGetSpecificMoviesData(){
        val position = 0
        val wrongSpecificMoviesData = viewModel.getSpecificDataMovies(position, false)
        checkSpecificWrongMovie(expected = dummyMovies, actual = wrongSpecificMoviesData, positionAt = position)
    }

    /**
     * testing to get specific tv shows, with wrong passing argument based on position
     *
     * note: for obtain specific data of tv shows, the arguments isMovies must false.
     *       in this function we pass the wrong arguments isMovies, namely true.
     * */
    @Test
    fun testWrongGetSpecificTvShowsData(){
        val position = 1
        val wrongSpecificTvShowsData = viewModel.getSpecificDataMovies(position, true)
        checkSpecificWrongMovie(expected = dummyTvShows, actual = wrongSpecificTvShowsData, positionAt = position)
    }

    /**
     * check size of movies data
     *
     * @param expected      expected data
     * @param actual        real data / actual data
     * @output              success, if size of actual data same with expected size data
     * */
    private fun checkMoviesDataSize(expected: List<Movies>, actual: List<Movies>){
        assertNotNull(actual)
        assertEquals(expected.size, actual.size)
    }

    /**
     * check specific movie, whether is same
     *
     * @param expected      expected data
     * @param actual        real data / actual data
     * @param positionAt    the position of the data you want to check
     *
     * @output              success, if actual data same with expected data
     * */
    private fun checkSpecificMovie(expected: List<Movies>, actual: Movies, positionAt: Int) {
        assertNotNull(actual)
        assertEquals(expected[positionAt].title, actual.title)
        assertEquals(expected[positionAt].poster, actual.poster)
        assertEquals(expected[positionAt].duration, actual.duration)
        assertEquals(expected[positionAt].director, actual.director)
        assertEquals(expected[positionAt].rating, actual.rating)
        assertEquals(expected[positionAt].genre.size, actual.genre.size)
        assertEquals(expected[positionAt].overview, actual.overview)
    }

    /**
     * check specific movie, whether is wrong
     *
     * @param expected      expected data
     * @param actual        real data / actual data
     * @param positionAt    the position of the data you want to check
     *
     * @output              success, if actual data not same with expected data
     * */
    private fun checkSpecificWrongMovie(expected: List<Movies>, actual: Movies, positionAt: Int){
        assertNotNull(actual)
        assertNotSame(expected[positionAt].title, actual.title)
        assertNotSame(expected[positionAt].poster, actual.poster)
        assertNotSame(expected[positionAt].duration, actual.duration)
        assertNotSame(expected[positionAt].director, actual.director)
        assertNotSame(expected[positionAt].rating, actual.rating)
        assertNotSame(expected[positionAt].genre.size, actual.genre.size)
        assertNotSame(expected[positionAt].overview, actual.overview)
    }
}
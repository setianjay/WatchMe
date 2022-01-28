package com.setianjay.watchme.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.ui.home.contents.ContentsViewModel
import com.setianjay.watchme.utils.DataDummyUtil
import junit.framework.Assert.*
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ContentsViewModelTest {

    private lateinit var viewModel: ContentsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<MovieEntity>>>

    private val dummyMovies get() = DataDummyUtil.generateDataMovies()

    private val dummyTvShows get() = DataDummyUtil.generateDataTvShows()

    @Before
    fun setup() {
        viewModel = ContentsViewModel(movieRepository)
    }

    /**
     * testing to get movies data size, equal with movies resources data size
     *
     * note: for obtain movies data, the arguments isMovies must true
     * */
    @Test
    fun testGetDataMoviesSize() {
        val movies = MutableLiveData<Resource<List<MovieEntity>>>()
        movies.value = Resource.success(dummyMovies)

        `when`(movieRepository.getMoviesPopular()).thenReturn(movies)

        val movie = viewModel.getDataMovies().value
        verify(movieRepository).getMoviesPopular()
        assertNotNull(movie?.data)
        movie?.data?.let { checkMoviesDataSize(expected = dummyMovies, actual = it) }

        viewModel.getDataMovies().observeForever(observer)
        verify(observer).onChanged(movie)
    }


    /**
     * testing to get tv shows data size, equal with tv shows resources data size
     *
     * note: for obtain tv shows data, the arguments isMovies must false
     * */
    @Test
    fun testGetDataTvShowsSize() {
        val tvShows = MutableLiveData<Resource<List<MovieEntity>>>()
        tvShows.value = Resource.success(dummyTvShows)

        `when`(movieRepository.getTvPopular()).thenReturn(tvShows)

        val tv = viewModel.getTvMovie().value
        verify(movieRepository).getTvPopular()
        assertNotNull(tv?.data)
        tv?.data?.let{ checkMoviesDataSize(expected = dummyTvShows, actual = it ) }

        viewModel.getTvMovie().observeForever(observer)
        verify(observer).onChanged(tv)
    }


    /**
     * check size of movies data
     *
     * @param expected      expected data
     * @param actual        real data / actual data
     * @output              success, if size of actual data same with expected size data
     * */
    private fun checkMoviesDataSize(expected: List<MovieEntity>, actual: List<MovieEntity>){
        assertNotNull(actual)
        assertEquals(expected.size, actual.size)
    }
}
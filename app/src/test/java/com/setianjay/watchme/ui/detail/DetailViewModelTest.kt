package com.setianjay.watchme.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.utils.DataDummyUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieEntity>>

    private val dummyMovies get() = DataDummyUtil.generateRemoteDataMovies()[0]
    private val movieId = dummyMovies.movieId

    private val dummyTv get() = DataDummyUtil.generateRemoteDataTv()[0]
    private val tvId = dummyTv.movieId

    @Before
    fun init(){
        viewModel = DetailViewModel(movieRepository)
    }


    /**
     * testing to get detail movies, equal with movies resources data based on movie id
     * */
    @Test
    fun testGetMovieDetail() {
        val movieResult = MutableLiveData<Resource<MovieEntity>>()
        movieResult.value = Resource.success(dummyMovies)

        `when`(movieRepository.getMovieDetail(movieId)).thenReturn(movieResult)

        val movie = viewModel.getMovieDetail(movieId).value

        verify(movieRepository).getMovieDetail(movieId)
        assertNotNull(movie?.data)
        movie?.data?.let { checkSpecificMovie(dummyMovies, it ) }

        viewModel.getMovieDetail(movieId).observeForever(observer)
        verify(observer).onChanged(movie)
    }

    /**
     * testing to get detail tv, equal with movies resources data based on movie id
     * */
    @Test
    fun testGetTvDetail() {
        val tvResult = MutableLiveData<Resource<MovieEntity>>()
        tvResult.value = Resource.success(dummyTv)

        `when`(movieRepository.getTvDetail(tvId)).thenReturn(tvResult)

        val tv = viewModel.getTvDetail(tvId).value

        verify(movieRepository).getTvDetail(tvId)
        assertNotNull(tv?.data)
        tv?.data?.let { checkSpecificMovie(dummyTv, it) }

        viewModel.getTvDetail(tvId).observeForever(observer)
        verify(observer).onChanged(tv)
    }

    /**
     * check specific movie, whether is same
     *
     * @param expected      expected data
     * @param actual        real data / actual data
     *
     * @output              success, if actual data same with expected data
     * */
    private fun checkSpecificMovie(expected: MovieEntity, actual: MovieEntity) {
        assertNotNull(actual)
        assertEquals(expected.title, actual.title)
        assertEquals(expected.poster, actual.poster)
        assertEquals(expected.release, actual.release)
        assertEquals(expected.movieId, actual.movieId)
        assertEquals(expected.rating, actual.rating)
        assertEquals(expected.genre, actual.genre)
        assertEquals(expected.overview, actual.overview)
    }
}
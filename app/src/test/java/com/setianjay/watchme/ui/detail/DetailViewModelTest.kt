package com.setianjay.watchme.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.util.TestUtil
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
    private lateinit var observer: Observer<MovieEntity>

    private val dummyMovies get() = DataDummyUtil.generateDataMovies()[0]
    private val movieId = dummyMovies.movieId

    @Before
    fun init(){
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun testGetMovieDetail() {
        val movieResult = MutableLiveData<MovieEntity>()
        movieResult.value = dummyMovies

        `when`(movieRepository.getMovieDetail(movieId)).thenReturn(movieResult)

        val movie = viewModel.getMovieDetail(movieId).value

        verify(movieRepository).getMovieDetail(movieId)
        assertNotNull(movie)
        movie?.let{ TestUtil.checkSpecificMovie(dummyMovies, it) }

        viewModel.getMovieDetail(movieId).observeForever(observer)
        verify(observer).onChanged(movie)
    }
}
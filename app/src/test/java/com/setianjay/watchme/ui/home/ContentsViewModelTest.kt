package com.setianjay.watchme.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.Resource
import com.setianjay.watchme.ui.home.contents.ContentsViewModel
import com.setianjay.watchme.util.TestUtil
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
class ContentsViewModelTest {

    private lateinit var viewModel: ContentsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setup() {
        viewModel = ContentsViewModel(movieRepository)
    }

    @Test
    fun testGetDataMovies() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(20)

        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = Resource.success(dummyMovies)

        `when`(movieRepository.getMoviesPopular()).thenReturn(movies)

        val movie = viewModel.getDataMovies().value
        verify(movieRepository).getMoviesPopular()
        assertNotNull(movie?.data)
        movie?.data?.let { TestUtil.checkMoviesDataSize(expected = dummyMovies, actual = it) }

        viewModel.getDataMovies().observeForever(observer)
        verify(observer).onChanged(movie)
    }

    @Test
    fun testGetDataTvShows() {
        val dummyTvShows = pagedList
        `when`(dummyTvShows.size).thenReturn(20)

        val tvShows = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        tvShows.value = Resource.success(dummyTvShows)

        `when`(movieRepository.getTvPopular()).thenReturn(tvShows)

        val tv = viewModel.getTvMovie().value
        verify(movieRepository).getTvPopular()
        assertNotNull(tv?.data)
        tv?.data?.let{ TestUtil.checkMoviesDataSize(expected = dummyTvShows, actual = it ) }

        viewModel.getTvMovie().observeForever(observer)
        verify(observer).onChanged(tv)
    }
}
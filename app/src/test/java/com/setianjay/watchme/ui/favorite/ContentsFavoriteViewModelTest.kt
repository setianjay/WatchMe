package com.setianjay.watchme.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.ui.favorite.contents.ContentsFavoriteViewModel
import com.setianjay.watchme.util.TestUtil
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
class ContentsFavoriteViewModelTest {

    private lateinit var viewModel: ContentsFavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setup() {
        viewModel = ContentsFavoriteViewModel(movieRepository)
    }

    @Test
    fun getAllMovieBookmarked(){
        val dummyMoviesBookmarked = pagedList
        `when`(dummyMoviesBookmarked.size).thenReturn(5)

        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMoviesBookmarked

        `when`(movieRepository.getAllMovieBookmarked()).thenReturn(movies)

        val favMovies = viewModel.getAllMovieBookmarked().value
        verify(movieRepository).getAllMovieBookmarked()

        assertNotNull(favMovies)
        favMovies?.let { TestUtil.checkMoviesDataSize(dummyMoviesBookmarked, it) }

        viewModel.getAllMovieBookmarked().observeForever(observer)
        verify(observer).onChanged(favMovies)
    }

    @Test
    fun getAllTvBookmarked(){
        val dummyTvBookmarked = pagedList
        `when`(dummyTvBookmarked.size).thenReturn(5)

        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyTvBookmarked

        `when`(movieRepository.getAllTvBookmarked()).thenReturn(movies)

        val favTv = viewModel.getAllTvMovieBookmarked().value
        verify(movieRepository).getAllTvBookmarked()

        assertNotNull(favTv)
        favTv?.let { TestUtil.checkMoviesDataSize(dummyTvBookmarked, it) }

        viewModel.getAllTvMovieBookmarked().observeForever(observer)
        verify(observer).onChanged(favTv)
    }
}
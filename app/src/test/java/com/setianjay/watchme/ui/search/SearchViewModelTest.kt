package com.setianjay.watchme.ui.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.setianjay.watchme.data.repository.MovieRepository
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.util.TestUtil
import com.setianjay.watchme.utils.DataDummyUtil
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
class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setup() {
        viewModel = SearchViewModel(movieRepository)
    }

    @Test
    fun searchMovie(){
        val dummySearchResult = listOf(DataDummyUtil.getDetailMovie())

        val result = MutableLiveData<List<MovieEntity>>()
        result.value = dummySearchResult

        `when`(movieRepository.searchMovie(DataDummyUtil.getDetailMovie().title)).thenReturn(result)

        val searchResult = viewModel.searchMovie(DataDummyUtil.getDetailMovie().title).value

        verify(movieRepository).searchMovie(DataDummyUtil.getDetailMovie().title)
        assertNotNull(searchResult)
        searchResult?.let { TestUtil.checkSpecificMovie(DataDummyUtil.getDetailMovie(), searchResult[0])  }
        viewModel.searchMovie(DataDummyUtil.getDetailMovie().title).observeForever(observer)
        verify(observer).onChanged(searchResult)
    }
}
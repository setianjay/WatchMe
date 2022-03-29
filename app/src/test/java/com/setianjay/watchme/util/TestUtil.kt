package com.setianjay.watchme.util

import com.setianjay.watchme.data.source.local.entity.MovieEntity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull

object TestUtil {

    /**
     * check size of movies data
     *
     * @param expected      expected data
     * @param actual        real data / actual data
     * @output              success, if size of actual data same with expected size data
     * */
    fun <Expected, Actual>checkMoviesDataSize(expected: List<Expected>, actual: List<Actual>){
        assertNotNull(actual)
        assertEquals(expected.size, actual.size)
    }

    /**
     * check specific movie, whether is same
     *
     * @param expected      expected data
     * @param actual        real data / actual data
     *
     * @output              success, if actual data same with expected data
     * */
    fun checkSpecificMovie(expected: MovieEntity, actual: MovieEntity){
        assertEquals(expected.title, actual.title)
        assertEquals(expected.poster, actual.poster)
        assertEquals(expected.release, actual.release)
        assertEquals(expected.movieId, actual.movieId)
        assertEquals(expected.rating, actual.rating)
        assertEquals(expected.genre, actual.genre)
        assertEquals(expected.overview, actual.overview)
    }
}
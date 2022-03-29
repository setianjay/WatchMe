package com.setianjay.watchme.ui.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.setianjay.watchme.R
import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.ui.MainActivity
import com.setianjay.watchme.utils.DataDummyUtil
import com.setianjay.watchme.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class HomeScreenTest {
    private val dummyMovies: List<MovieEntity> get() = DataDummyUtil.generateDataMovies()
    private val dummyTvShows: List<MovieEntity> get() = DataDummyUtil.generateDataTvShows()

    private lateinit var context: Context

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
        context = ApplicationProvider.getApplicationContext()
    }

    /**
     * test whether the movies the content of the movie item category appears
     *
     * @output movies item category appears in layout
     * */
    @Test
    fun showDataMovies() {
        onView(withText(R.string.categories_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    /**
     * test whether the tv shows the content of the tv shows item category appears
     *
     * @output tv shows item category appears in layout
     * */
    @Test
    fun showDataTvShows() {
        onView(withText(R.string.categories_tv_shows)).perform(click())
        onView(withText(R.string.categories_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }
}
package com.setianjay.watchme.ui.detail

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
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
class DetailScreenTest {
    private val dummyMovies: List<MovieEntity> get() = DataDummyUtil.generateDataMovies()
    private val dummyTvShows: List<MovieEntity> get() = DataDummyUtil.generateDataTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    /**
     * test action to display a details movie based on the clicked movie
     *
     * @output display a detail of movie
     * */
    @Test
    fun showDetailMovie() {
        onView(withText(R.string.categories_movies))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
        val position = 0
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )

        checkDetailContent()
    }

    /**
     * test action to display a details tv show based on the clicked tv show
     *
     * @output display a detail of tv show
     * */
    @Test
    fun showDetailTvShow() {
        onView(withText(R.string.categories_tv_shows))
            .perform(click())
        onView(withText(R.string.categories_tv_shows))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
        val position = 0
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )
        checkDetailContent()
    }

    /**
     * test action to display a details movie and then perform add to favorite action
     *
     * @output image bookmark on detail screen changes to be [R.drawable.ic_bookmark_selected]
     * */
    @Test
    fun showDetailMovieAndAddToFavorite() {
        showDetailMovie()
        onView(withId(R.id.iv_bookmark)).perform(click())
    }

    /**
     * test action to display a details movie and then perform remove from favorite action
     *
     * @output image bookmark on detail screen changes to be [R.drawable.ic_bookmark_not_selected]
     * */
    @Test
    fun showDetailMovieAndRemoveFromFavorite() {
        showDetailMovie()
        onView(withId(R.id.iv_bookmark)).perform(click())
    }


    /**
     * test action to display a details tv show and then perform add to favorite action
     *
     * @output image bookmark on detail screen changes to be [R.drawable.ic_bookmark_selected]
     * */
    @Test
    fun showDetailTvShowsAndAddToFavorite() {
        showDetailTvShow()
        onView(withId(R.id.iv_bookmark)).perform(click())
    }

    /**
     * test action to display a details movie and then perform remove from favorite action
     *
     * @output image bookmark on detail screen changes to be [R.drawable.ic_bookmark_not_selected]
     * */
    @Test
    fun showDetailTvShowsAndRemoveFromFavorite() {
        showDetailTvShow()
        onView(withId(R.id.iv_bookmark)).perform(click())
    }

    companion object{
        /**
         * checking all view in detail screen
         *
         * @output success, if all checking for view has passed
         * */
        fun checkDetailContent() {
            onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
            onView(withId(R.id.iv_bookmark)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
            onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        }
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }
}
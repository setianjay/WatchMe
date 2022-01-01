package com.setianjay.watchme.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.setianjay.watchme.R
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

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    /**
     * test whether the movies the content of the movie item category appears
     *
     * @output movies item category appears in layout
     * */
    @Test
    fun showDataMovies(){
        onView(withText(R.string.categories_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(DataDummyUtil.generateDataMovies().size))
    }

    /**
     * test whether the tv shows the content of the tv shows item category appears
     *
     * @output tv shows item category appears in layout
     * */
    @Test
    fun showDataTvShows(){
        onView(withText(R.string.categories_tv_shows)).perform(click())
        onView(withText(R.string.categories_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(DataDummyUtil.generateDataTvShows().size))
    }

    /**
     * test action to display a details movie based on the clicked movie
     *
     * @output display a detail of movie
     * */
    @Test
    fun showDetailMovie(){
        onView(withText(R.string.categories_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(DataDummyUtil.generateDataMovies().size))
        onView(withId(R.id.rv_content)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(withText(DataDummyUtil.generateDataMovies()[0].title)))
        onView(withId(R.id.tv_duration)).check(matches(withText(DataDummyUtil.generateDataMovies()[0].duration)))
    }

    /**
     * test action to display a details tv show based on the clicked tv show
     *
     * @output display a detail of tv show
     * */
    @Test
    fun showDetailTvShow(){
        onView(withText(R.string.categories_tv_shows)).perform(click())
        onView(withText(R.string.categories_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(DataDummyUtil.generateDataTvShows().size))
        onView(withId(R.id.rv_content)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(matches(withText(DataDummyUtil.generateDataTvShows()[0].title)))
        onView(withId(R.id.tv_duration)).check(matches(withText(DataDummyUtil.generateDataTvShows()[0].duration)))
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }
}
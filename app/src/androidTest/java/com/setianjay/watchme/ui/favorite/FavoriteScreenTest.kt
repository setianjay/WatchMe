package com.setianjay.watchme.ui.favorite

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.setianjay.watchme.R
import com.setianjay.watchme.ui.MainActivity
import com.setianjay.watchme.ui.detail.DetailScreenTest
import com.setianjay.watchme.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class FavoriteScreenTest {

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    /**
     * test to show empty favorite movie
     *
     * @output      display image information
     * */
    @Test
    fun showEmptyFavoriteMovie() {
        favoriteMovie()
        onView(withId(R.id.iv_information)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_message)).check(matches(isDisplayed()))
    }

    /**
     * test to show empty favorite tv show
     *
     * @output      display image information
     * */
    @Test
    fun showEmptyFavoriteTv() {
        favoriteTv()
        onView(withId(R.id.iv_information)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_message)).check(matches(isDisplayed()))
    }

    /**
     * test to show favorite movie
     *
     * @output      display list of favorite
     * */
    @Test
    fun showFavoriteMovie() {
        onView(withText(R.string.categories_movies)).check(matches(isDisplayed()))
        val position = 0
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )

        DetailScreenTest.checkDetailContent()

        onView(withId(R.id.iv_bookmark)).perform(click())
        pressBack()

        favoriteMovie()
        onView(withId(R.id.rv_favorite)).check(matches(isDisplayed()))
    }

    /**
     * test to show favorite tv
     *
     * @output      display list of favorite
     * */
    @Test
    fun showFavoriteTv() {
        onView(withText(R.string.categories_tv_shows)).check(matches(isDisplayed()))
        onView(withText(R.string.categories_tv_shows)).perform(click())
        val position = 0
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )

        DetailScreenTest.checkDetailContent()

        onView(withId(R.id.iv_bookmark)).perform(click())
        pressBack()

        favoriteTv()
        onView(withId(R.id.rv_favorite)).check(matches(isDisplayed()))
    }

    /**
     * test to show favorite movie then go to detail by clicking the favorite
     *
     * @output      display detail of movie
     * */
    @Test
    fun showFavoriteMovieThenToDetail() {
        favoriteMovie()

        val position = 0
        onView(withId(R.id.rv_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )

        DetailScreenTest.checkDetailContent()
    }

    /**
     * test to show favorite tv then go to detail by clicking the favorite
     *
     * @output      display detail of movie
     * */
    @Test
    fun showFavoriteTvThenToDetail() {
        favoriteTv()

        val position = 0
        onView(withId(R.id.rv_favorite)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )

        DetailScreenTest.checkDetailContent()
    }

    companion object {

        private fun favoriteMovie() {
            onView(withId(R.id.iv_menu)).perform(click())
            onView(withText(R.string.menu_movie_favorite)).check(matches(isDisplayed()))
            onView(withText(R.string.menu_movie_favorite)).perform(click())
            onView(withText(R.string.categories_movies)).check(matches(isDisplayed()))
        }

        private fun favoriteTv() {
            onView(withId(R.id.iv_menu)).perform(click())
            onView(withText(R.string.menu_movie_favorite)).check(matches(isDisplayed()))
            onView(withText(R.string.menu_movie_favorite)).perform(click())
            onView(withText(R.string.categories_tv_shows)).check(matches(isDisplayed()))
            onView(withText(R.string.categories_tv_shows)).perform(click())
        }
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }
}
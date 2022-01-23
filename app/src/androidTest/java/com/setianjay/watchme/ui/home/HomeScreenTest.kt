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

    /**
     * test action to display a details movie based on the clicked movie
     *
     * @output display a detail of movie
     * */
    @Test
    fun showDetailMovie() {
        onView(withText(R.string.categories_movies)).check(matches(isDisplayed()))
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

        checkDetailContent(dummyMovies)
    }

    /**
     * test action to display a details tv show based on the clicked tv show
     *
     * @output display a detail of tv show
     * */
    @Test
    fun showDetailTvShow() {
        onView(withText(R.string.categories_tv_shows)).perform(click())
        onView(withText(R.string.categories_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                DataDummyUtil.generateDataTvShows().size
            )
        )
        val position = 0
        onView(withId(R.id.rv_content)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )
        checkDetailContent(dummyTvShows)
    }

    /**
     * checking all view in detail screen based on movie data and position
     *
     * @param movies        data resources
     *
     * @output              success, if all checking for view has passed
     * */
    private fun checkDetailContent(movies: List<MovieEntity>){
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(movies[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(withText(movies[0].genre)))
        onView(withId(R.id.tv_release)).check(matches(withText(context.getString(R.string.release, movies[0].release))))
        onView(withId(R.id.tv_rating)).check(matches(withText(movies[0].rating.toString())))

    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }
}
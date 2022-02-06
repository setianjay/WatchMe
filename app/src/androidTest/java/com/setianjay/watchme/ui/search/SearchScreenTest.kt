package com.setianjay.watchme.ui.search

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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
class SearchScreenTest {
    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    /**
     * test action for searching a movie
     *
     * @output      list of movie based on query input search
     * */
    @Test
    fun searchMovie(){
        onView(withId(R.id.tv_search)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_search)).perform(click())
        onView(withId(R.id.et_search)).check(matches(isDisplayed()))
        onView(withId(R.id.et_search)).perform(typeText("re"))
        onView(withId(R.id.btn_search)).perform(click())
        onView(withId(R.id.rv_result_search)).check(matches(isDisplayed()))
    }

    /**
     * test action for searching a movie then go to detail by clicking the movie
     *
     * @output      detail of movie
     * */
    @Test
    fun searchMovieThenToDetail(){
        searchMovie()
        val position = 0
        onView(withId(R.id.rv_result_search)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                position,
                click()
            )
        )

        DetailScreenTest.checkDetailContent()
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }
}
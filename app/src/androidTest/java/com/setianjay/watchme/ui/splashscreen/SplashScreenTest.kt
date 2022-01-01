package com.setianjay.watchme.ui.splashscreen

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.setianjay.watchme.R
import com.setianjay.watchme.ui.MainActivity
import com.setianjay.watchme.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class SplashScreenTest {

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }


    /**
     * test for splash screen process
     *
     * @output  loading progress has reached 100% percentage and displays the home page
     * */
    @Test
    fun progressLoadingTest() {
        //if the say hello for username is display
        Espresso.onView(ViewMatchers.withText(R.string.hello_username))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }
}
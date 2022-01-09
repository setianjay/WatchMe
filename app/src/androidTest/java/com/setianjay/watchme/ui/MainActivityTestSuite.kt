package com.setianjay.watchme.ui

import com.setianjay.watchme.ui.home.HomeScreenTest
import com.setianjay.watchme.ui.splashscreen.SplashScreenTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SplashScreenTest::class,
    HomeScreenTest::class
)
class MainActivityTestSuite
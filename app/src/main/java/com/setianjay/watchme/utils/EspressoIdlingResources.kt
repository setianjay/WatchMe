package com.setianjay.watchme.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResources {

    private const val RESOURCE = "GLOBAL"
    private val countingIdlingResource = CountingIdlingResource(RESOURCE)

    val idlingResource get() = countingIdlingResource

    fun increment(){
        countingIdlingResource.increment()
    }

    fun decrement(){
        countingIdlingResource.decrement()
    }
}
package com.setianjay.watchme.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

object BackgroundUtil {

    private val job = Job()

    val coroutineScope by lazy { CoroutineScope(Dispatchers.IO + job) }
}
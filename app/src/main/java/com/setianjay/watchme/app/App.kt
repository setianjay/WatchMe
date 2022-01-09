package com.setianjay.watchme.app

import android.app.Application
import com.setianjay.watchme.BuildConfig
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber(){
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
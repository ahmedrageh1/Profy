package com.rageh.profy

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ProfyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("application", "created")
    }
}
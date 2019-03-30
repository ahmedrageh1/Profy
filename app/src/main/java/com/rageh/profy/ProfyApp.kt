package com.rageh.profy

import android.app.Application
import android.util.Log
import com.rageh.profy.dagger.component.ApplicationComponent

class ProfyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationComponent.init(this).inject(this)
        Log.d("application", "created")
    }
}
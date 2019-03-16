package com.rageh.profy

import android.app.Application
import android.util.Log
import com.rageh.profy.dagger.component.ApplicationComponent
import com.rageh.profy.util.AudioUtils
import javax.inject.Inject

class ProfyApp : Application() {
    @Inject
    lateinit var audioUtils: AudioUtils

    override fun onCreate() {
        super.onCreate()
        ApplicationComponent.init(this).inject(this)
        Log.d("application", "created")
    }
}
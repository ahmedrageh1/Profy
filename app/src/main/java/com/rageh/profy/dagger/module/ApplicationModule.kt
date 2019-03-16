package com.rageh.profy.dagger.module

import android.app.Application
import android.content.Context
import com.rageh.profy.dagger.ScopeApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {
    @ScopeApplication
    @Provides
    fun applicationContext(): Context {
        return application
    }
}
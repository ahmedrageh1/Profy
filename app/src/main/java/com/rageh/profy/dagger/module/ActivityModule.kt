package com.rageh.profy.dagger.module

import android.content.Context
import com.rageh.profy.dagger.ScopeActivity
import com.rageh.profy.ui.base.BaseActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule(private val activity: BaseActivity) {
    @ScopeActivity
    @Provides
    @Named("activity")
    fun context(): Context {
        return activity
    }

    @ScopeActivity
    @Provides
    fun activity(): BaseActivity {
        return activity
    }
}
package com.rageh.profy.dagger.module

import android.content.Context
import com.rageh.profy.dagger.ScopeActivity
import com.rageh.profy.ui.view.base.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: BaseActivity) {
    @ScopeActivity
    @Provides
    fun context(): Context {
        return activity
    }

    @ScopeActivity
    @Provides
    fun activity(): BaseActivity {
        return activity
    }
}
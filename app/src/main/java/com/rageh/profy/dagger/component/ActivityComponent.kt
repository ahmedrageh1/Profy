package com.rageh.profy.dagger.component

import com.rageh.profy.dagger.ScopeActivity
import com.rageh.profy.dagger.module.ActivityModule
import com.rageh.profy.ui.view.activity.SplashActivity
import com.rageh.profy.ui.view.base.BaseActivity
import dagger.Subcomponent

@ScopeActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    companion object {
        fun init(activity: BaseActivity): ActivityComponent {
            return ApplicationComponent.get().plus(ActivityModule(activity))
        }
    }

    fun inject(splashActivity: SplashActivity)
}
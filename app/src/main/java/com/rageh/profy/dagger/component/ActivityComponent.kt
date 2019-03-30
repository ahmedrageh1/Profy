package com.rageh.profy.dagger.component

import com.rageh.profy.dagger.ScopeActivity
import com.rageh.profy.dagger.module.ActivityModule
import com.rageh.profy.dagger.module.FragmentModule
import com.rageh.profy.ui.view.activity.SplashActivity
import com.rageh.profy.ui.view.base.BaseActivity
import dagger.Subcomponent

@ScopeActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    companion object {
        private lateinit var component: ActivityComponent
        fun init(activity: BaseActivity): ActivityComponent {
            component = ApplicationComponent.get().plus(ActivityModule(activity))
            return component
        }

        fun get(): ActivityComponent {
            return component
        }
    }

    fun plus(fragmentModule: FragmentModule): FragmentComponent
    fun inject(activity: BaseActivity)
    fun inject(splashActivity: SplashActivity)
}
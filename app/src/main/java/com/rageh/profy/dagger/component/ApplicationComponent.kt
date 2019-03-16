package com.rageh.profy.dagger.component

import com.rageh.profy.ProfyApp
import com.rageh.profy.dagger.ScopeApplication
import com.rageh.profy.dagger.module.ActivityModule
import com.rageh.profy.dagger.module.ApplicationModule
import com.rageh.profy.dagger.module.AudioUtilsModule
import dagger.Component

@ScopeApplication
@Component(modules = [ApplicationModule::class, AudioUtilsModule::class])
interface ApplicationComponent {
    companion object {
        private lateinit var component: ApplicationComponent
        fun init(profyApp: ProfyApp): ApplicationComponent {
            component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(profyApp))
                .build()
            return component
        }

        fun get(): ApplicationComponent {
            return component
        }
    }

    fun inject(application: ProfyApp)
    fun plus(activityModule: ActivityModule): ActivityComponent

}



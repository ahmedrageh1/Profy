package com.rageh.profy.dagger.component

import com.rageh.profy.dagger.ScopeFragment
import com.rageh.profy.dagger.module.FragmentModule
import com.rageh.profy.ui.view.base.BaseFragment
import dagger.Subcomponent

@ScopeFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {
    companion object {
        private lateinit var component: FragmentComponent
        fun init(fragment: BaseFragment): FragmentComponent {
            return ActivityComponent.get().plus(FragmentModule(fragment))
        }

        fun get(): FragmentComponent {
            return component
        }

    }

    fun inject(fragment: BaseFragment)
}
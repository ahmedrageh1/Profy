package com.rageh.profy.dagger.module

import android.content.Context
import com.rageh.profy.dagger.ScopeFragment
import com.rageh.profy.ui.view.base.BaseActivity
import com.rageh.profy.ui.view.base.BaseFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: BaseFragment) {
    @ScopeFragment
    @Provides
    fun context(): Context {
        return fragment.activity!!
    }

    @ScopeFragment
    @Provides
    fun activity(): BaseActivity {
        return fragment.activity!! as BaseActivity
    }
}
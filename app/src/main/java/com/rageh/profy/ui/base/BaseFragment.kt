package com.rageh.profy.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rageh.profy.dagger.component.FragmentComponent

class BaseFragment : Fragment() {
    lateinit var fragmentComponent: FragmentComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent = FragmentComponent.init(this)
        fragmentComponent.inject(this)
    }
}
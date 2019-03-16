package com.rageh.profy.ui.view.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rageh.profy.dagger.component.ActivityComponent

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = ActivityComponent.init(this)
    }

}
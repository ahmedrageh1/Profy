package com.rageh.profy.ui.view.activity

import android.os.Bundle
import com.rageh.profy.R
import com.rageh.profy.ui.view.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        setContentView(R.layout.activity_splash)
    }
}

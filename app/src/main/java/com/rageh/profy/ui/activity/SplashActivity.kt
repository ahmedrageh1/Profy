package com.rageh.profy.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.rageh.profy.R
import com.rageh.profy.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },
            1000
        )
    }

    override fun onBackPressed() {

    }
}
